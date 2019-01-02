<template>
  <div>
    <div id="card">
      <div id="credit_cards">
        <i class="fa fa-cc-visa fa-fw fa-2x"></i>
        <i class="fa fa-cc-mastercard fa-fw fa-2x"></i>
        <i class="fa fa-globe fa-fw fa-2x"></i>
      </div>

      <form @submit.prevent="submit">
        <div class="form-group" :class="{ 'form-group--error': $v.cardNumber.$error }"
             id="card-number-field">
          <the-mask mask="####-####-####-####"
                    class="form-control"
                    v-model.trim="$v.cardNumber.$model"
                    id="cardNumber"/>
        </div>
        <div class="error" v-if="(!$v.cardNumber.required && $v.cardNumber.dirty)">Name is
          required
        </div>
        <div class="error" v-if="!$v.cardNumber.minLength">Name must have at least
          {{$v.cardNumber.$params.minLength.min}} letters.
        </div>

        <div id="expiration-date">
          <the-mask type="text"
                    mask="F#/F#" :tokens="{
                    F : {
                    pattern: /[0-1]/
                    },
                    '#': {pattern: /\d/}
                    }"
                    placeholder="MM/ГГ"
                    v-model.trim="$v.date.$model"
                    class="form-control" id="date"/>
        </div>
        <div id="cvv">
          <the-mask mask="###"
                    placeholder="CVV"
                    v-model.trim="$v.cvv.$model"
                    class="form-control"
                    id="cvv"/>
        </div>
      </form>
    </div>
    <div id="payment">
      <form>
        <div>
          <label>Сумма</label>
          <the-mask mask="#####"
                    id="payment_from"
                    class="form-control"
                    v-model="$v.sum.$model"
                    placeholder="от 1 000 до 75 000 Р"/>
        </div>
        <div>
          <label>Комментарий</label>
          <input type="text"
                 maxlength="150"
                 id="bic"
                 class="form-control"
                 v-model="$v.comment.$model"
                 placeholder="до 150 символов">
        </div>
        <div>
          <label>Ваша эл.почта</label>
          <input type="mail"
                 id="payment_number"
                 class="form-control"
                 v-model="$v.mail.$model"
                 placeholder="для квитанций об оплате">
        </div>
      </form>
      <div class="aqua-button">
        <span class="aqua-button__bg"></span>
        <a href="" rel="nofollow" class="aqua-button__title">
          Заплатить
        </a>
      </div>
    </div>

  </div>
</template>

<script>
  import {minLength, required, between, email} from 'vuelidate/lib/validators'

  export default {
    name: "PayAnyCard",

    data() {
      return {
        cardNumber: '',
        date: '',
        cvv: '',
        sum: '',
        comment: '',
        mail: '',
        submitStatus: null
      }
    },
    validations: {
      cardNumber: {
        required,
        minLength: minLength(16)
      },

      date: {
        required,
        minLength: minLength(4)
      },

      cvv: {
        required,
        minLength: minLength(3)
      },

      sum: {
        required,
        between: between(1000,75000)
      },

      mail: {
        email
      },

      comment: {}
    },
    methods: {
      submit() {
        console.log('submit!')
        this.$v.$touch()
        if (this.$v.$invalid) {
          this.submitStatus = 'ERROR'
        } else {
          // do your submit logic here
          this.submitStatus = 'PENDING'
          setTimeout(() => {
            this.submitStatus = 'OK'
          }, 500)
        }
      }
    }
  }
</script>

<style scoped>

  #card {
    margin: 2% 2% 5% 2%;
    float: left;
    width: 40%;
    min-width: 350px;
    max-width: 420px;
    height: 250px;
    border-radius: 10px;
    background: #fafafa;
    -webkit-box-shadow: 0px 6px 16px 0px rgba(163, 157, 163, 1);
    -moz-box-shadow: 0px 6px 16px 0px rgba(163, 157, 163, 1);
    box-shadow: 0px 6px 16px 0px rgba(163, 157, 163, 1);
  }

  #card #credit_cards {
    margin-top: 7px;
    margin-left: 60%;
  }

  #card #card-number-field #cardNumber {
    width: 90%;
    margin: 40px 5% 5% 5%
  }

  #card #expiration-date #date {
    margin-left: 5%;
    width: 110px;

  }

  #card #expiration-date {
    display: inline;
  }

  #card #cvv #cvv {
    width: 80px;
  }

  #card #cvv {
    margin-left: 40px;
    display: inline;
  }

  .form-control {
    height: 30px;
    border: 0;
    outline: 0;
    background: transparent;
    border-bottom: 1px solid black;
  }

  #credit_cards i {
    margin: 0 1% 0 1%
  }

  #payment {
    display: block;
    float: left;
    margin: 2% 10% 0 10%;
  }

  #payment form div label {
    font-weight: bold;
  }

  #payment form div {
    margin-bottom: 10%;
  }

  #payment form div input {
    width: 300px;
  }

  #payment_from {
    margin-left: 108px;
  }

  #bic {
    margin-left: 52px;
  }

  #payment_number {
    margin-left: 48px;
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

  @media (max-width: 1297px) {
    #payment {
      margin-left: 2%;
    }
  }

  @media (max-width: 1162px) {

    #payment {
      margin-left: 12%;
    }

    #card {
      margin: 2% 2% 5% 20%;
    }

  }

  @media (max-width: 768px) {

    #payment form div input {
      width: 200px;
    }

    #payment_from {
      margin-left: 88px;
    }

    #bic {
      margin-left: 32px;
    }

    #payment_number {
      margin-left: 28px;
    }

    .main {
      width: 100%;
      min-width: 470px;
    }

    #card {
      margin: 2% 2% 5% 10%;
    }

    #payment {
      float: left;
      margin: 2% auto 2% 7%;
      min-width: 470px;
    }

    .aqua-button {
      float: right;
      margin-right: 25%;
    }
  }

</style>