<template>

  <div>
    <span class="simple_span">Сформеруйте платежку и загрузите её в свой банк для подписи</span>

    <div id="payment">
      <form>
        <div>
          <label for="payment_from">От кого</label>
          <input
              type="number"
              id="payment_from"
              class="form-control"
              placeholder="ИНН или название плательщика">
        </div>
        <div>
          <label for="bic">БИК</label>
          <input
              type="number"
              id="bic"
              class="form-control"
              placeholder="">
        </div>
        <div>
          <label for="payment_number">Номер счета</label>
          <input
              type="number"
              id="payment_number"
              class="form-control"
              placeholder="для квитанций об оплате">
        </div>
        <div>
          <label for="payment_for">За что</label>
          <input
              type="text"
              id="payment_for"
              class="form-control"
              placeholder="назначение платежа">
        </div>
        <div>
          <label for="payment_nds">НДС</label>
          <input
              type="text"
              id="payment_nds"
              class="form-control"
              placeholder="">
        </div>
        <div>
          <label for="payment_sum" class="label_sum">Сколько</label>
          <input
              type="number"
              id="payment_sum"
              class="form-control"
              placeholder="">
        </div>

        <div class="aqua-button">
          <span class="aqua-button__bg"></span>
          <button
              type="submit"
              class="aqua-button__title">
            Получить файл для интернет-банка
          </button>
        </div>
      </form>

    </div>
  </div>

</template>

<script>
  export default {
    name: "PayYouBank"
  }
</script>

<style scoped>
  .simple_span {
    float: left;
    margin-left: 10%;
    margin-top: 2%;
    font-weight: bold;
    font-size: 1.2em;
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
    margin-left: 200px;
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

  #payment_nds {
    margin-left: 223px;
  }

  #payment_sum {
    margin-left: 190px;
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

  input.ng-invalid.ng-touched {
    border: 0.1em solid lightcoral;
  }

</style>