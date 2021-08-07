<template>
  <v-container fluid>
    <v-main>
      <nav-bar></nav-bar>
      <video-card></video-card>
      <v-file-input v-model="files" show-size label="File input"></v-file-input>
      <v-btn @click="upload" color="primary">Upload</v-btn>
      <div>
        <video id="videoPlayer" controls>
          <source src=http://localhost:9090/api/download/test/jisu.mpd
          type=application/dash+xml>
        </video>
      </div>
    </v-main>
  </v-container>
</template>
<script>
import NavBar from "@/components/common/NavBar.vue";
import VideoCard from "@/components/VideoCard.vue";
import { uploadFiles } from "@/../apiUtil/api";
import "dashjs";

export default {
  name: "Home",
  components: {
    NavBar: NavBar,
    VideoCard: VideoCard,
  },
  data: () => ({
    files: [],
  }),
  methods: {
    async upload() {
      var fd = new FormData();
      fd.append("content", this.files);
      const res = await uploadFiles.getRes(fd);
      console.log(res);
    },
  },
  // mounted() {
  //   // var url = "https://dash.akamaized.net/envivio/EnvivioDash3/manifest.mpd";
  //   var url = "assets/video/jisu.mpd";
  //   var player = dashjs.MediaPlayer().create();
  //   console.log(player);
  //   console.log(document.querySelector("#videoPlayer"));
  //   player.initialize(document.querySelector("#videoPlayer"), url, true);
  //   console.log("확인!!");
  // },
};
</script>
