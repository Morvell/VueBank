<template>
  <div>
    <div v-if="!profile">Необходимо авторизоваться через
      <a href="/login">Google</a>
    </div>
    <div v-else>
      <div class="header">
        <div id="info">
          <h3>Индивидуальный предприниматель Швецова Мария Валерьевна</h3><br>
          <div id="main_info">
            <span id="telefon">+79049870727</span>
            <a href="www.mary.com">www.mary.com</a>
            <a href="mailto:mary@tochka.com">mary@tochka.com</a>
          </div>
          <div id="hiden_info">
            <div id="about_company">
              <details>
                <summary>Информация о компании</summary>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laboriosam placeat,
                  aliquid, atque, quo qui quam aspernatur velit quisquam et minus possimus eum,
                  optio sequi minima esse nisi similique voluptatibus laudantium!</p>
              </details>
            </div>
            <div id="details">
              <details>
                <summary>Показать реквизиты</summary>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laboriosam placeat,
                  aliquid, atque, quo qui quam aspernatur velit quisquam et minus possimus eum,
                  optio sequi minima esse nisi similique voluptatibus laudantium!</p>
              </details>
            </div>
          </div>

        </div>
        <div id="customer_img">
          <img
              src="https://is3-ssl.mzstatic.com/image/thumb/Purple118/v4/f5/c7/98/f5c79856-ff84-d9f4-2cad-593ca6be6ea9/AppIcon-1x_U007emarketing-85-220-6.png/246x0w.jpg"
              alt="Ваша фотографияz">
        </div>
      </div>

      <div class="pay-card-nav">
        <div class="nav">
          <router-link to="/">
            <i class="fa fa-credit-card fa-fw fa-1x"></i>
            <span>Заплатить</span></router-link></div>
        <div class="nav">
          <router-link to="request">
            <i class="fa fa-desktop fa-fw fa-1x"></i>
            <span>Запросить</span></router-link></div>
      </div>

      <router-view></router-view>

      <div class="customer_services">
        <div id="company_name">
          <span>О компании Индивидульный предприниматель Швецова Мария Валерьевна</span>
        </div>
        <div class="service">
          <div class="img_container"><img
              src="https://www.thailand-trip.org/wp-content/uploads/2016/01/plyazh_tri_trang_beach_na_phukete.jpg"
              alt="Услуга препринимателя"><br></div>
          <div id="service_discription">
            <h3>Какая-то птица №1</h3><br>
          </div>
          <div id="service_price">
            <h3>138 рублей</h3><br>
          </div>

        </div>
        <div class="service">
          <div class="img_container"><img
              src="https://www.thailand-trip.org/wp-content/uploads/2016/01/plyazh_tri_trang_beach_na_phukete.jpg"
              alt="Услуга препринимателя"><br></div>

          <div id="service_discription">
            <h3>Какая-то птица №2</h3><br>
          </div>
          <div id="service_price">
            <h3>50 рублей</h3><br>
          </div>
        </div>
        <div class="service">
          <div class="img_container"><img
              src="https://www.thailand-trip.org/wp-content/uploads/2016/01/plyazh_tri_trang_beach_na_phukete.jpg"
              alt="Услуга препринимателя"><br></div>
          <div id="service_discription">
            <h3>Какая-то птица №2</h3><br>
          </div>
          <div id="service_price">
            <h3>50 рублей</h3><br>
          </div>
        </div>
        <div class="service">
          <div class="img_container"><img
              src="https://www.thailand-trip.org/wp-content/uploads/2016/01/plyazh_tri_trang_beach_na_phukete.jpg"
              alt="Услуга препринимателя"><br></div>
          <div id="service_discription">
            <h3>Какая-то птица №2</h3><br>
          </div>
          <div id="service_price">
            <h3>50 рублей</h3><br>
          </div>
        </div>

      </div>
      <notifications group="foo" />
      <!--<span class="textarea" [class.textarea&#45;&#45;hidden]="!isMoreShow">-->
      <!--Lorem ipsum dolor sit amet, consectetur adipisicing elit. Debitis officiis voluptatibus unde placeat quisquam. Explicabo recusandae laboriosam possimus consequuntur veniam, deleniti dolor veritatis praesentium. Itaque, illo! Id voluptatibus dolorem commodi itaque, amet. Assumenda, neque officia. Voluptatem labore hic voluptas incidunt ullam debitis iste minima rerum quo tenetur, vitae quaerat provident, soluta sunt doloremque aliquid molestiae dolor cupiditate ex. Vitae assumenda voluptatibus, sequi. Ipsa quam hic quis, fugiat voluptatibus ipsum quod quibusdam blanditiis, labore, at voluptates. Enim itaque voluptatum, ex illum? Laudantium cupiditate dicta rerum, alias odio minima qui. Accusamus dolore fugiat excepturi dolor ipsa dicta voluptates vero perferendis saepe quaerat, maxime, nisi. Qui sunt, vitae delectus culpa similique molestias ex quasi totam facere expedita odio inventore cumque, placeat quia non?-->
      <!--</span>-->
      <!--<span class="show-more" (click)="isMoreShow=true" [hidden]="isMoreShow" > Показать еще </span>-->
      <!--<span class="hide" (click)="isMoreShow=false" [hidden]="!isMoreShow"> Спрятать </span>-->

      <div class="full_info_about_service">

      </div>

      <div class="footer">
      </div>
    </div>
  </div>
</template>

<script>
  import Pay from "components/pay/Pay.vue";

  export default {
    components: {
      Pay
    },
    data() {
      return {
        messages: frontendData.messages,
        profile: frontendData.profile
      }
    }
  }
</script>

<style>

  @import url("https://use.fontawesome.com/releases/v5.6.3/css/all.css");

  * {
    margin: 0;
    padding: 0;
    outline: none;
  }

  body,
  html {
    width: 100%;
    height: 100%;
  }

  body {
    font-family: Trebuchet MS, Helvetica;
  }

  h1,
  h2,
  h3,
  h4,
  h5 {
    font-family: 'Roboto Slab', serif;
    font-weight: lighter;
  }

  .header {
    margin: 10px 5%;
    display: block;
    width: 90%;
    float: left;
    margin-bottom: 3%;
    -webkit-box-shadow: 0px 5px 10px -2px rgba(163, 157, 163, 1);
    -moz-box-shadow: 0px 5px 10px -2px rgba(163, 157, 163, 1);
    box-shadow: 0px 5px 10px -2px rgba(163, 157, 163, 1);
  }

  /*инфа про кастомера*/
  .header #info {
    float: left;
    margin: 1.5%;
    margin-right: 10%;
    width: 60%;
  }

  .header #info h3 {
    font-size: 1.5em;
    font-weight: bold;
  }

  .header #info #main_info {
    margin-top: 2%;
    margin-bottom: 2%;
    display: block;
  }

  .header #info #main_info a {
    text-decoration: none;
    color: #285ce9;
  }

  .header #info #main_info > a:not(:last-child) {
    margin-right: 5%;
  }

  .header #info #main_info #telefon {
    margin-right: 5%;
    color: rgba(117, 133, 140, 1);
  }

  .header #info > div {
    margin-bottom: 3%;
  }

  #hiden_info > div > details > summary {
    color: #285ce9;
    margin-bottom: 5%;
  }

  details > summary::-webkit-details-marker {
    display: none;
  }

  /*фоточка кастомера*/
  .header #customer_img {
    float: right;
    margin: 20px;
  }

  .header #customer_img img {
    background: #fafafa;
    float: left;
    width: 100%;
    max-width: 150px;
  }

  @media (max-width: 768px) {
    .header {
      width: 100%;
      min-width: 470px;
    }

    .header #customer_img {
      float: left;
    }

    .header #info {
      width: 100%;

    }
  }

  /*фотогалерея*/
  .customer_services {
    margin-left: 5%;
    margin-right: 5%;
    margin-top: 4%;
    float: left;
  }

  #company_name {
    padding-bottom: 5%;
  }

  #company_name span {
    font-weight: bold;
    font-size: 1.3em;
  }

  .service {
    margin: auto 2%;
    width: 20%;
    min-width: 100px;
    border: 2px solid silver;
    float: left;
    display: block;
    border-radius: 10px;
    background: #fafafa;
    -webkit-box-shadow: 0px 6px 16px 0px rgba(163, 157, 163, 1);
    -moz-box-shadow: 0px 6px 16px 0px rgba(163, 157, 163, 1);
    box-shadow: 0px 6px 16px 0px rgba(163, 157, 163, 1);
  }

  .service #service_discription {
    margin: 0 15px;
  }

  .service #service_price {
    margin: 0 15px;
    color: rgba(117, 133, 140, 1);

  }

  .service .img_container {
    padding: 10px 15px;
  }

  .service .img_container img {
    display: block;
    margin: 0 auto;
    background: #fafafa;
    width: auto;
    height: auto;
    max-width: 100%;
    min-width: 10%;
  }


  .nav a{
    text-decoration: none;
  }

  .pay-card-nav {
    margin-bottom: 40px;
    margin-left: 5%;
    min-width: 500px;
  }

  .nav {
    display: inline-block;
    margin-top: 3%;
    margin-right: 0.5%;
  }

  a {
    background-color: transparent;
    color: black;
    padding: 0.8em;
    text-decoration: none;
  }

  .router-link-exact-active {
    background-color: #f7f7f7;
    cursor: pointer;
  }

  a:hover {
    background-color: #f7f7f7;
  }

  a:active {
    background-color: #E8E8EE;
  }

  a:visited {
    background-color: transparent;
  }

  @media (max-width: 845px) {
    .service {
      margin: auto 1.9%;
    }
  }

  @media (max-width: 768px) {
    .customer_services {
      width: 100%;
    }

    .service {
      width: 45%;
      margin-bottom: 2%;
    }
  }

  @media (max-width: 590px) {
    .service {
      float: none;
      width: 80%;
      margin: 1% 9% 2% 9%;
    }
  }

  #check {
    display: none;
  }

  .show-more {
    margin-left: 5%;
  }

  .hide {
    margin-left: 5%;
  }

  .textarea {
    margin-left: 5%;
    margin-right: 5%;
    margin-top: 4%;
    float: left;
    width: 90%;
    margin-bottom: 20px;
  }

  .textarea--hidden {

    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 3;
    -webkit-box-orient: vertical;
  }

  .full_info_about_service:hover {
    background: #f0f0f0;
    /* Цвет фона */
    white-space: normal;
    /* Обычный перенос текста */
  }

  .footer {
    margin-left: 5%;
    margin-right: 5%;
    margin-top: 4%;
    margin-bottom: 3%;
    float: left;
    width: 90%;
  }


</style>
