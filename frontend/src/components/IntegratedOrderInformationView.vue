<template>

    <v-data-table
        :headers="headers"
        :items="integratedOrderInformation"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'IntegratedOrderInformationView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "orderId", value: "orderId" },
                { text: "menuId", value: "menuId" },
                { text: "foodId", value: "foodId" },
                { text: "payId", value: "payId" },
                { text: "status", value: "status" },
                { text: "customerId", value: "customerId" },
                { text: "address", value: "address" },
                { text: "qty", value: "qty" },
                { text: "options", value: "options" },
            ],
            integratedOrderInformation : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/integratedOrderInformations'))

            temp.data._embedded.integratedOrderInformations.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.integratedOrderInformation = temp.data._embedded.integratedOrderInformations;
        },
        methods: {
        }
    }
</script>

