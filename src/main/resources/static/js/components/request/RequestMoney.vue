<template>
  <div class="main">
    <div class="main_pay_you_bank">
      <span class="simple_span">Создайте платежку, а Индивидуальный предприниматель
      Швецова Мария Валерьевна подпишет её у себя в интернет-банке</span>

      <div id="payment">
        <form @submit.prevent="submit">
          <div class="form-group"
               :class="{ 'form-group--error': $v.requestConsumer.$error }">
            <label for="payment_from">ИНН получателя</label>
            <input
                id="payment_from"
                class="form-control"
                v-model.trim="$v.requestConsumer.$model"
                @input="delayTouch($v.requestConsumer)"
                placeholder="ИНН или название плательщика"/>
          </div>
          <div class="form-group"
               :class="{ 'form-group--error': $v.bic.$error }">
            <label for="bic">БИК</label>
            <the-mask
                mask="### ### ###"
                id="bic"
                class="form-control"
                v-model.trim="$v.bic.$model"
                @input="delayTouch($v.bic )"
                placeholder=""/>
          </div>
          <div class="form-group"
               :class="{ 'form-group--error': $v.paymentNumber.$error }">
            <label for="payment_number">Номер счета</label>
            <the-mask
                mask="####################"
                type="number"
                maxlength="20"
                id="payment_number"
                class="form-control"
                v-model.trim="$v.paymentNumber.$model"
                @input="delayTouch($v.paymentNumber )"
                placeholder="для квитанций об оплате"/>
          </div>
          <div class="form-group"
               :class="{ 'form-group--error': $v.paymentFor.$error }">
            <label for="payment_for">За что</label>
            <input
                disabled
                type="text"
                id="payment_for"
                class="form-control"
                v-model.trim="$v.paymentFor.$model"
                @input="delayTouch($v.paymentFor )"
                placeholder="назначение платежа">
          </div>
          <div id="nds_labels">
            <span @click="nds18">НДС 18%</span>
            <span @click="nds10">НДС 10%</span>
            <span @click="nonds">без НДС</span>
          </div>
          <div class="form-group"
               :class="{ 'form-group--error': $v.paymentSum.$error }">
            <label for="payment_sum" class="label_sum">Сколько</label>
            <the-mask
                mask="#####"
                id="payment_sum"
                class="form-control"
                v-model.trim="$v.paymentSum.$model"
                @input="delayTouch($v.paymentSum )"
                placeholder=""/>
          </div>
          <div class="form-group"
               :class="{ 'form-group--error': $v.telephoneNumber.$error }">
            <label for="telephone" class="label_sum">Номер телефона</label>
            <the-mask
                mask="+7(###)-###-##-##"
                id="telephone"
                class="form-control"
                v-model.trim="$v.telephoneNumber.$model"
                @input="delayTouch($v.telephoneNumber )"
            />
          </div>
          <div class="form-group"
               :class="{ 'form-group--error': $v.mail.$error }">
            <label for="mail" class="label_sum">Эл.почта</label>
            <input
                type="mail"
                id="mail"
                class="form-control"
                v-model.trim="$v.mail.$model"
                @input="delayTouch($v.mail)"
                placeholder="Для уведомлений об оплате">
          </div>

        </form>

        <div class="aqua-button" @click="submit">
          <span class="aqua-button__bg"></span>
          <button
              type="submit"
              class="aqua-button__title">
            Создать платеж
          </button>
        </div>
        <div id="clean_form" @click="cleanForm">
          <span>Очистить форму</span>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
  import {and, between, maxLength, minLength, or, required, email, numeric} from 'vuelidate/lib/validators'

  const touchMap = new WeakMap();

  export default {
    name: "RequestMoney",

    data() {
      return {
        requestConsumer: '',
        bic: '',
        paymentNumber: '',
        paymentFor: '',
        paymentSum: '',
        telephoneNumber: '',
        mail:''
      }
    },
    validations: {
      requestConsumer: {
        required
      },

      bic: {
        required,
        minLength: minLength(9)
      },

      paymentNumber: {
        required
      },

      paymentFor: {
        required
      },

      paymentSum: {
        required,
        between: between(1000, 75000)
      },

      telephoneNumber: {
        required,
        numeric
      },

      mail: {
        required,
        email
      }
    },
    methods: {
      nds18() {
        this.paymentFor = 'НДС 18%'
      },

      nds10() {
        this.paymentFor = 'НДС 10%'
      },

      nonds() {
        this.paymentFor = 'без НДС'
      },

      cleanForm() {
        this.$v.$reset();
        this.requestConsumer = '';
        this.bic = '';
        this.paymentNumber = '';
        this.paymentFor = '';
        this.paymentSum = '';
        this.mail='';
        this.telephoneNumber='';
      },

      delayTouch($v) {
        $v.$reset();

        if (touchMap.has($v)) {
          clearTimeout(touchMap.get($v))
        }
        touchMap.set($v, setTimeout($v.$touch, 1000));
      },

      submit() {
        console.log('submit!');
        this.$v.$touch();

        if (this.$v.$invalid) {
          this.$notify({
            group: 'foo',
            type: 'error',
            title: 'Ошибка валидации',
            text: 'Проверьте правильность заполнения полей'
          });

        } else {

          const message = {
            paymentFrom: this.paymentFrom,
            bic: this.bic,
            paymentNumber: this.paymentNumber,
            paymentFor: this.paymentFor,
            paymentSum: this.paymentSum
          };

          let id = 0;

          this.$resource('/payYouBank').save({}, message).then(result =>
              result.json().then(t => {
                id = t;
                this.$notify({
                  group: 'foo',
                  title: '',
                  text: 'Данные отправлены'
                });

                setTimeout(() => {
                  var link = document.createElement('a');
                  link.href = '/payYouBank/' + id;
                  link.download = 'file.pdf';
                  link.target = '_blank';
                  link.dispatchEvent(new MouseEvent('click'));
                }, 3000);
              }), () => {
            this.$notify({
              group: 'foo',
              type: 'error',
              title: 'Ошибка',
              text: 'При отправке данных произошла ошибка'
            });
          });

          this.$v.$reset();
          this.requestConsumer = '';
          this.bic = '';
          this.paymentNumber = '';
          this.paymentFor = '';
          this.paymentSum = '';
          this.mail='';
          this.telephoneNumber='';

        }
      }
    }
  }
</script>

<style scoped>
  .simple_span {
    float: left;
    margin-left: 10%;
    margin-top: 2%;
    margin-right: 5%;
    font-weight: bold;
    font-size: 1.2em;
  }

  .form-group {
    display: inline-block;
  }

  #payment {
    display: block;
    float: left;
    margin: 2% 10% 0 10%;
  }

  #payment form div label {
    font-weight: bold;
    color: gray;
  }

  #payment form div {
    margin-bottom: 10%;
  }

  #payment form div input {
    width: 500px;
  }

  .form-control {
    height: 30px;
    border: 0;
    outline: 0;
    background: transparent;
    border-bottom: 1px solid black;
  }

  #payment_from {
    margin-left: 130px;
  }

  #bic {
    margin-left: 226px;
  }

  #payment_number {
    margin-left: 158px;
  }

  #payment_for {
    margin-left: 207px;
  }

  #nds_labels {
    margin-top: -9%;
    margin-left: 260px;
  }

  #payment_sum {
    margin-left: 190px;
  }

  #telephone {
    margin-left: 122px;
  }

  #mail {
    margin-left: 182px;
  }
  #payment form div #payment_sum {
    width: 200px;
  }

  .aqua-button:after,
  .aqua-button:before {
    position: absolute;
    z-index: 0;
    display: block;
    left: 0;
    right: 0;
    height: 16px;
    border-left: 2px solid;
    border-right: 2px solid;
    content: "";
    border-color: #231f20;
  }

  .aqua-button:before {
    top: 0;
    border-top: 2px solid;
  }

  .aqua-button:after {
    bottom: 0;
    border-bottom: 2px solid;
  }

  .aqua-button__bg,
  .aqua-button__bg-opacity {
    -webkit-transition: opacity .3s ease-in-out .2s;
    -o-transition: opacity .3s ease-in-out .2s;
    transition: opacity .3s ease-in-out .2s;
  }

  .aqua-button__bg {
    position: absolute;
    top: 0;
    left: -10px;
    right: 0;
    bottom: -8px;
    background: url(https://tochka.com/theme/main/img/button/button_1.png) left 5px no-repeat;
    background-size: 100% 100%;
    opacity: .6;
  }

  .aqua-button {
    display: inline-block;
    position: relative;
    text-align: center;
  }

  .aqua-button__title {
    display: inline-block;
    position: relative;
    font-weight: 700;
    cursor: pointer;
    padding: 10px 30px;
    text-align: center;
    white-space: nowrap;
    vertical-align: middle;
    text-decoration: none;
    color: #231f20;
    z-index: 1;
    width: 100%;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
  }

  .aqua-button__title {
    padding: 15px 35px;
  }

  button {
    background: transparent;
    border: none;
  }

  .form-group--error input {
    border-bottom: 1px solid lightcoral;
    background: #fff4f8;
  }

  @media (max-width: 1184px) {
    #payment_from {
      margin-left: 90px;
    }

    #bic {
      margin-left: 186px;
    }

    #payment_number {
      margin-left: 118px;
    }

    #payment_for {
      margin-left: 167px;
    }

    #nds_labels {
      margin-top: -9%;
      margin-left: 220px;
    }

    #payment_sum {
      margin-left: 150px;
    }

    #telephone {
      margin-left: 82px;
    }

    #mail {
      margin-left: 142px;
    }

    #payment form div input {
      width: 400px;
    }
  }

  #nds_labels span {
    margin-right: 1%;
    color: blue;
    cursor: pointer;
  }

  #clean_form {
    margin-top: 2%;
    margin-bottom: 2%;
    color: blue;
    cursor: pointer;
  }

  @media (max-width: 964px) {
    #payment_from {
      margin-left: 70px;
    }

    #bic {
      margin-left: 166px;
    }

    #payment_number {
      margin-left: 98px;
    }

    #payment_for {
      margin-left: 147px;
    }

    #nds_labels {
      margin-top: -9%;
      margin-left: 200px;
    }

    #payment_sum {
      margin-left: 130px;
    }

    #telephone {
      margin-left: 62px;
    }

    #mail {
      margin-left: 122px;
    }

    #payment form div input {
      width: 300px;
    }
  }

  @media (max-width: 630px) {
    .main_pay_you_bank {
      min-width: 500px;
    }

    #payment_from {
      margin-left: 30px;
      margin-right: 5px;
    }

    #bic {
      margin-left: 126px;
      margin-right: 5px;
    }

    #payment_number {
      margin-left: 58px;
      margin-right: 5px;
    }

    #payment_for {
      margin-left: 107px;
      margin-right: 5px;
    }

    #nds_labels {
      margin-top: -9%;
      margin-left: 160px;
    }

    #payment_sum {
      margin-left: 90px;
    }

    #telephone {
      margin-left: 22px;
      margin-right: 5px;
    }

    #mail {
      margin-left: 82px;
      margin-right: 5px;
    }

    #payment form div input {
      width: 220px;
    }
  }

  .main {
    margin-left: 5%;
    margin-right: 5%;
    margin-top: 4%;
    margin-bottom: 3%;
    float: left;
    width: 90%;
    -webkit-box-shadow: 0px 5px 10px -2px rgba(163, 157, 163, 1);
    -moz-box-shadow: 0px 5px 10px -2px rgba(163, 157, 163, 1);
    box-shadow: 0px 5px 10px -2px rgba(163, 157, 163, 1);
  }

  @media (max-width: 768px) {
    .main {
      width: 100%;
      min-width: 470px;
    }
  }

  @media (max-width: 478px) {
    .nav {
      margin-top: 6%;
    }
  }
</style>