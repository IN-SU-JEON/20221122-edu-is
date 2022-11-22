<template>

    <v-card outlined>
        <v-card-title>
            DeliveryFoodList # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="RiderId" v-model="item.riderId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CustomerId" v-model="item.customerId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Address" v-model="item.address" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'DeliveryFoodListViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/deliveryFoodLists/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

