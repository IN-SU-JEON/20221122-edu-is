<template>

    <v-data-table
        :headers="headers"
        :items="deliveryFoodList"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'DeliveryFoodListView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "riderId", value: "riderId" },
                { text: "customerId", value: "customerId" },
                { text: "address", value: "address" },
            ],
            deliveryFoodList : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/deliveryFoodLists'))

            temp.data._embedded.deliveryFoodLists.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.deliveryFoodList = temp.data._embedded.deliveryFoodLists;
        },
        methods: {
        }
    }
</script>

