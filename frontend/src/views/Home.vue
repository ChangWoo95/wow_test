<template>
  <v-container fluid>
    <v-main>
      <nav-bar></nav-bar>
      <video-card></video-card>
      <div><video id="videoPlayer" controls></video></div>
    </v-main>
  </v-container>
</template>
<script>
import NavBar from "@/components/common/NavBar.vue";
import VideoCard from "@/components/VideoCard.vue";
import dashjs from "dashjs";
export default {
  name: "Home",
  components: {
    NavBar: NavBar,
    VideoCard: VideoCard,
  },
  mounted() {
    // var url = "https://dash.akamaized.net/envivio/EnvivioDash3/manifest.mpd";
    var url = "assets/video/jisu.mpd";
    var player = dashjs.MediaPlayer().create();
    console.log(player);
    console.log(document.querySelector("#videoPlayer"));
    player.initialize(document.querySelector("#videoPlayer"), url, true);
    console.log("확인!!");
  },
};
</script>
