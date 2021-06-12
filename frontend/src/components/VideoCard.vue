<template>
  <v-row>
    <v-col cols="3">
      <v-card width="400">
        <!-- Thumnail image 시작 -->
        <v-img height="200px" src="@/assets/youtube.jpg"> </v-img>
        <!-- Thumnail image 끝 -->
        <v-card-text>
          <v-row>
            <v-col cols="2">
              <v-avatar size="30">
                <img
                  alt="user"
                  src="https://cdn.pixabay.com/photo/2020/06/24/19/12/cabbage-5337431_1280.jpg"
                />
              </v-avatar>
            </v-col>
            <v-col cols="7">
              <p>조만기</p>
            </v-col>
            <v-col cols="2">
              <v-btn icon>
                <v-icon justify="center">mdi-dots-vertical</v-icon>
              </v-btn>
            </v-col>
          </v-row>
        </v-card-text>
      </v-card>
    </v-col>
    <v-col cols="3">
      <v-card width="400">
        <!-- Thumnail image 시작 -->
        <v-img height="200px" src="@/assets/youtube.jpg"> </v-img>
        <!-- Thumnail image 끝 -->
        <v-card-text>
          <v-row>
            <v-col cols="2">
              <v-avatar size="30">
                <img
                  alt="user"
                  src="https://cdn.pixabay.com/photo/2020/06/24/19/12/cabbage-5337431_1280.jpg"
                />
              </v-avatar>
            </v-col>
            <v-col cols="7">
              <p>조만기</p>
            </v-col>
            <v-col cols="2">
              <v-btn icon>
                <v-icon justify="center">mdi-dots-vertical</v-icon>
              </v-btn>
            </v-col>
          </v-row>
        </v-card-text>
      </v-card>
    </v-col>
    <v-col cols="3">
      <v-card width="400">
        <!-- Thumnail image 시작 -->
        <v-img height="200px" src="@/assets/youtube.jpg"> </v-img>
        <!-- Thumnail image 끝 -->
        <v-card-text>
          <v-row>
            <v-col cols="2">
              <v-avatar size="30">
                <img
                  alt="user"
                  src="https://cdn.pixabay.com/photo/2020/06/24/19/12/cabbage-5337431_1280.jpg"
                />
              </v-avatar>
            </v-col>
            <v-col cols="7">
              <p>조만기</p>
            </v-col>
            <v-col cols="2">
              <v-btn icon>
                <v-icon justify="center">mdi-dots-vertical</v-icon>
              </v-btn>
            </v-col>
          </v-row>
        </v-card-text>
      </v-card>
    </v-col>
    <v-col cols="3">
      <v-card width="400">
        <!-- Thumnail image 시작 -->
        <v-img height="200px" src="@/assets/youtube.jpg"> </v-img>
        <!-- Thumnail image 끝 -->
        <v-card-text>
          <v-row>
            <v-col cols="2">
              <v-avatar size="30">
                <img
                  alt="user"
                  src="https://cdn.pixabay.com/photo/2020/06/24/19/12/cabbage-5337431_1280.jpg"
                />
              </v-avatar>
            </v-col>
            <v-col cols="7">
              <p>조만기</p>
            </v-col>
            <v-col cols="2">
              <v-btn icon>
                <v-icon justify="center">mdi-dots-vertical</v-icon>
              </v-btn>
            </v-col>
          </v-row>
        </v-card-text>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
export default {
  name: "VideoCard",
  data: () => ({
    messages: [
      {
        from: "You",
        message: "Sure, I'll see you later.",
        time: "10:42am",
        color: "deep-purple lighten-1",
      },
      {
        from: "John Doe",
        message: "Yeah, sure. Does 1:00pm work?",
        time: "10:37am",
        color: "green",
      },
      {
        from: "You",
        message: "Did you still want to grab lunch today?",
        time: "9:47am",
        color: "deep-purple lighten-1",
      },
    ],
  }),
};
</script>

<style></style>
