<template>

    <v-data-table
        :headers="headers"
        :items="noticeInfo"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'NoticeInfoView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "noticeId", value: "noticeId" },
                { text: "customoerId", value: "customoerId" },
                { text: "message", value: "message" },
            ],
            noticeInfo : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/noticeInfos'))

            temp.data._embedded.noticeInfos.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.noticeInfo = temp.data._embedded.noticeInfos;
        },
        methods: {
        }
    }
</script>

