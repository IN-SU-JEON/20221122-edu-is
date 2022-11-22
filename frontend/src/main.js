 /*eslint-disable*/
import Vue from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import Managing from "./components";
import router from './router';
Vue.config.productionTip = false;

const axios = require("axios").default;

// backend host url
axios.backend = null; //"http://localhost:8088";

// axios.backendUrl = new URL(axios.backend);
axios.fixUrl = function(original){

  if(!axios.backend && original.indexOf("/")==0) return original;

  var url = null;

  try{
    url = new URL(original);
  }catch(e){
    url = new URL(axios.backend + original);
  }

  if(!axios.backend) return url.pathname;

  url.hostname = axios.backendUrl.hostname;
  url.port = axios.backendUrl.port;

  return url.href;
}

const templateFiles = require.context("./components", true);
Vue.prototype.$ManagerLists = [];
templateFiles.keys().forEach(function(tempFiles) {
  if (!tempFiles.includes("Manager.vue") && tempFiles.includes("vue")) {
    Vue.prototype.$ManagerLists.push(
      tempFiles.replace("./", "").replace(".vue", "")
    );
  }
});
Vue.use(Managing);
const pluralCaseList = []

pluralCaseList.push( {plural: "orders", pascal: "Order"} )

pluralCaseList.push( {plural: "menuLists", pascal: "MenuList"} )
pluralCaseList.push( {plural: "integratedOrderInformations", pascal: "IntegratedOrderInformation"} )
pluralCaseList.push( {plural: "foods", pascal: "Food"} )
pluralCaseList.push( {plural: "menus", pascal: "Menu"} )

pluralCaseList.push( {plural: "orderDetailLists", pascal: "OrderDetailList"} )
pluralCaseList.push( {plural: "menuLists", pascal: "MenuList"} )
pluralCaseList.push( {plural: "deliveries", pascal: "Delivery"} )

pluralCaseList.push( {plural: "deliveryFoodLists", pascal: "DeliveryFoodList"} )
pluralCaseList.push( {plural: "paymentinformations", pascal: "Paymentinformation"} )

pluralCaseList.push( {plural: "noticeInfos", pascal: "NoticeInfo"} )

pluralCaseList.push( {plural: "noticeInfos", pascal: "NoticeInfo"} )

Vue.prototype.$ManagerLists.forEach(function(item, idx) {
  pluralCaseList.forEach(function(tmp) {
    if(item.toLowerCase() == tmp.pascal.toLowerCase()) {
      var obj = {
        name: item,
        plural: tmp.plural
      }
      Vue.prototype.$ManagerLists[idx] = obj
    }
  })
})

new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount("#app");
