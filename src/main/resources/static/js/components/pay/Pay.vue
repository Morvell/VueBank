<template>
  <div>
    <div class="pay-card-nav">
      <div class="nav">
        <router-link to="/pay/pay-any-card">
          <i class="fa fa-credit-card fa-fw fa-1x"></i>
          <span>С карты любого банка</span></router-link></div>
      <div class="nav">
        <router-link to="/pay/pay-you-bank">
          <i class="fa fa-desktop fa-fw fa-1x"></i>
          <span>Из своего интернет-банка</span></router-link></div>
    </div>

    <div class="main">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Pay"
  }
</script>

<style scoped>


  .nav a{
    text-decoration: none;
  }

  .pay-card-nav {
    margin-left: 5%;
    min-width: 500px;
  }

  .nav {
    display: inline-block;
    margin-right: 0.5%;
  }

  a {
    background-color: transparent;
    color: black;
    padding: 0.8em;
    text-decoration: none;
  }

  .router-link-active {
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
      margin-top: 2%;
    }
  }

</style>