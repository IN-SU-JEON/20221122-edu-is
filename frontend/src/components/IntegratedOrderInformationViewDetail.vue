<template>

    <v-card outlined>
        <v-card-title>
            IntegratedOrderInformation # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="OrderId" v-model="item.orderId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="MenuId" v-model="item.menuId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="FoodId" v-model="item.foodId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PayId" v-model="item.payId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Status" v-model="item.status" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CustomerId" v-model="item.customerId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Address" v-model="item.address" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Qty" v-model="item.qty" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Options" v-model="item.options" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'IntegratedOrderInformationViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/integratedOrderInformations/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

