<template>

    <v-card outlined>
        <v-card-title>
            MenuList # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="MenuId" v-model="item.menuId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="MenuNm" v-model="item.menuNm" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'MenuListViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/menuLists/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

