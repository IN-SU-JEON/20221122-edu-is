<template>

    <v-card outlined>
        <v-card-title>
            NoticeInfo # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="NoticeId" v-model="item.noticeId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CustomoerId" v-model="item.customoerId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Message" v-model="item.message" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'NoticeInfoViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/noticeInfos/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

