
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import MenuListView from "./components/MenuListView"
import MenuListViewDetail from "./components/MenuListViewDetail"
import IntegratedOrderInformationView from "./components/IntegratedOrderInformationView"
import IntegratedOrderInformationViewDetail from "./components/IntegratedOrderInformationViewDetail"
import FoodManager from "./components/listers/FoodCards"
import FoodDetail from "./components/listers/FoodDetail"
import MenuManager from "./components/listers/MenuCards"
import MenuDetail from "./components/listers/MenuDetail"

import OrderDetailListView from "./components/OrderDetailListView"
import OrderDetailListViewDetail from "./components/OrderDetailListViewDetail"
import MenuListView from "./components/MenuListView"
import MenuListViewDetail from "./components/MenuListViewDetail"
import DeliveryManager from "./components/listers/DeliveryCards"
import DeliveryDetail from "./components/listers/DeliveryDetail"

import DeliveryFoodListView from "./components/DeliveryFoodListView"
import DeliveryFoodListViewDetail from "./components/DeliveryFoodListViewDetail"
import PaymentinformationManager from "./components/listers/PaymentinformationCards"
import PaymentinformationDetail from "./components/listers/PaymentinformationDetail"

import NoticeInfoManager from "./components/listers/NoticeInfoCards"
import NoticeInfoDetail from "./components/listers/NoticeInfoDetail"

import NoticeInfoView from "./components/NoticeInfoView"
import NoticeInfoViewDetail from "./components/NoticeInfoViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/menuLists',
                name: 'MenuListView',
                component: MenuListView
            },
            {
                path: '/menuLists/:id',
                name: 'MenuListViewDetail',
                component: MenuListViewDetail
            },
            {
                path: '/integratedOrderInformations',
                name: 'IntegratedOrderInformationView',
                component: IntegratedOrderInformationView
            },
            {
                path: '/integratedOrderInformations/:id',
                name: 'IntegratedOrderInformationViewDetail',
                component: IntegratedOrderInformationViewDetail
            },
            {
                path: '/foods',
                name: 'FoodManager',
                component: FoodManager
            },
            {
                path: '/foods/:id',
                name: 'FoodDetail',
                component: FoodDetail
            },
            {
                path: '/menus',
                name: 'MenuManager',
                component: MenuManager
            },
            {
                path: '/menus/:id',
                name: 'MenuDetail',
                component: MenuDetail
            },

            {
                path: '/orderDetailLists',
                name: 'OrderDetailListView',
                component: OrderDetailListView
            },
            {
                path: '/orderDetailLists/:id',
                name: 'OrderDetailListViewDetail',
                component: OrderDetailListViewDetail
            },
            {
                path: '/menuLists',
                name: 'MenuListView',
                component: MenuListView
            },
            {
                path: '/menuLists/:id',
                name: 'MenuListViewDetail',
                component: MenuListViewDetail
            },
            {
                path: '/deliveries',
                name: 'DeliveryManager',
                component: DeliveryManager
            },
            {
                path: '/deliveries/:id',
                name: 'DeliveryDetail',
                component: DeliveryDetail
            },

            {
                path: '/deliveryFoodLists',
                name: 'DeliveryFoodListView',
                component: DeliveryFoodListView
            },
            {
                path: '/deliveryFoodLists/:id',
                name: 'DeliveryFoodListViewDetail',
                component: DeliveryFoodListViewDetail
            },
            {
                path: '/paymentinformations',
                name: 'PaymentinformationManager',
                component: PaymentinformationManager
            },
            {
                path: '/paymentinformations/:id',
                name: 'PaymentinformationDetail',
                component: PaymentinformationDetail
            },

            {
                path: '/noticeInfos',
                name: 'NoticeInfoManager',
                component: NoticeInfoManager
            },
            {
                path: '/noticeInfos/:id',
                name: 'NoticeInfoDetail',
                component: NoticeInfoDetail
            },

            {
                path: '/noticeInfos',
                name: 'NoticeInfoView',
                component: NoticeInfoView
            },
            {
                path: '/noticeInfos/:id',
                name: 'NoticeInfoViewDetail',
                component: NoticeInfoViewDetail
            },


    ]
})
