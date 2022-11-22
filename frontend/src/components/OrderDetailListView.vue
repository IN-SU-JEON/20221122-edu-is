<template>

    <v-data-table
        :headers="headers"
        :items="orderDetailList"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'OrderDetailListView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "foodId", value: "foodId" },
                { text: "orderId", value: "orderId" },
                { text: "status", value: "status" },
                { text: "customerId", value: "customerId" },
                { text: "address", value: "address" },
            ],
            orderDetailList : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/orderDetailLists'))

            temp.data._embedded.orderDetailLists.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.orderDetailList = temp.data._embedded.orderDetailLists;
        },
        methods: {
        }
    }
</script>

