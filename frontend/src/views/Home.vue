<template>
  <v-container fluid>
    <v-main>
      <nav-bar></nav-bar>
      <video-card></video-card>
      <div>
        <!-- <video
          data-dashjs-player
          autoplay
          src="@/assets/video/jisu.mpd"
          controls
        ></video> -->

        <!-- <video data-dashjs-player autoplay controls>
          <source src="@/assets/video/jisu.mpd" type="application/dash+xml" />
        </video> -->
        <!-- <video data-dashjs-player autoplay controls>
          <source
            src="https://dash.akamaized.net/akamai/bbb_30fps/bbb_30fps.mpd"
            type="application/dash+xml"
          />
        </video> -->
        <!-- <video
          data-dashjs-player
          autoplay
          src="https://dash.akamaized.net/akamai/bbb_30fps/bbb_30fps.mpd"
          controls
        ></video> -->
        <!-- <video
          id="example-video"
          width="600"
          height="300"
          class="video-js vjs-default-skin"
          controls
        ></video> -->
        <!-- <video data-dashjs-player autoplay controls>
          <source
            src="../assets/video/jisoo_dash.mpd"
            type="application/dash+xml"
          />
        </video> -->
        <!-- <video
          id="example-video"
          width="600"
          height="300"
          class="video-js vjs-default-skin"
          controls
        ></video> -->

        <video
          id="example-video"
          width="960"
          height="540"
          class="video-js vjs-default-skin"
          controls
        >
          <source
            src="@/assets/video/test2/output.m3u8"
            type="application/x-mpegURL"
          />
        </video>
      </div>
    </v-main>
  </v-container>
</template>
<script src="https://vjs.zencdn.net/7.11.4/video.min.js"></script>
<script src="http://cdn.dashjs.org/v4.0.0/dash.all.min.js"></script>
<script>
import "/node_modules/dashjs/dist/dash.all.min.js";
// import videojs from "video.js";
import "dashjs";
// import "videojs-contrib-dash";
import NavBar from "@/components/common/NavBar.vue";
import VideoCard from "@/components/VideoCard.vue";

export default {
  name: "Home",
  components: {
    NavBar: NavBar,
    VideoCard: VideoCard,
  },
  mounted() {
    var player = videojs("example-video");
    player.play();
  },
  // methods: {},
  // mounted: function () {
  //   // const name = document.querySelector("video").id;
  //   // console.log(name);
  //   var player = videojs("example-video");

  //   player.ready(function () {
  //     player.src({
  //       src: "assets/video/jisoo_dash.mpd",
  //       type: "application/dash+xml",
  //     });

  //     player.play();
  //   });
  // },
};
</script>
