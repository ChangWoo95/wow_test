<template>
  <v-container fluid>
    <v-main>
      <nav-bar></nav-bar>
      <video-card></video-card>
    </v-main>
  </v-container>
</template>

<script>
import NavBar from "@/components/common/NavBar.vue";
import VideoCard from "@/components/VideoCard.vue";

export default {
  name: "Home",
  components: {
    NavBar: NavBar,
    VideoCard: VideoCard,
  },
};
</script>
