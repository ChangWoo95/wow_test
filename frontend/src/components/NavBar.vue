<template>
  <nav id="navbar">
    <v-app-bar class="white" flat app clipped-left >
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title class="font-weight-bold">
        <router-link to="/" class="black--text" style="text-decoration: none">
          Jodongari
        </router-link>
      </v-toolbar-title>
      <v-spacer></v-spacer>

      <v-text-field
        flat
        hide-details
        placeholder="검색"
        append-outer-icon="mdi-magnify"
        outlined
        dense
        tile
        v-model="searchText"
        @click:append="search"
        class="hidden-sm-and-down"
      >
      </v-text-field>

      <v-spacer></v-spacer>
      
      <v-menu offsetY>
        <template v-slot:activator="{ on: menu }">
          <v-tooltip bottom>
            <template v-slot:activator="{ on: tooltip }">
              <v-btn icon v-on="{ ...tooltip, ...menu }"
                ><v-icon size="25">mdi-video-plus</v-icon></v-btn
              >
            </template>
            <span>Create a video and more</span>
          </v-tooltip>
        </template>
        <v-list>
          <v-list-item router to="/studio">
            <v-list-item-icon class="mr-3"
              ><v-icon>mdi-play-box-outline</v-icon></v-list-item-icon
            >
            <v-list-item-title>Upload video</v-list-item-title>
          </v-list-item>
          <v-list-item>
            <v-list-item-icon class="mr-3"
              ><v-icon>mdi-access-point</v-icon></v-list-item-icon
            >
            <v-list-item-title>Go live</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>

      <v-tooltip bottom>
        <template v-slot:activator="{ on }">
          <v-btn icon v-on="on"> <v-icon size="25">mdi-apps</v-icon></v-btn>
        </template>
      </v-tooltip>
      <v-tooltip bottom>
        <template v-slot:activator="{ on }">
          <v-btn icon v-on="on" class="mr-7">
            <v-icon size="25">mdi-bell</v-icon></v-btn
          >
        </template>
        <span>Notifications</span>
      </v-tooltip>

      <v-menu offset-y left>
        <template v-slot:activator="{ on }">
          <v-btn small color="red" depressed fab v-on="on" class="white--text">
            조꼬삼
          </v-btn>
        </template>
      </v-menu>
    </v-app-bar>  
    

    <v-navigation-drawer
      v-model="drawer"
      absolute
      temporary
    >
      <v-list-item>
        <v-list-item-avatar>
          <v-img src="https://randomuser.me/api/portraits/men/78.jpg"></v-img>
        </v-list-item-avatar>

        <v-list-item-content>
          <v-list-item-title>content1</v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-divider></v-divider>

      <v-list dense>
        <v-list-item
          v-for="item in items"
          :key="item.title"
          link
        >
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </nav>
</template>

<script>
export default {
  data: () => ({
      drawer: null,
      searchText:'',
       items: [
          { title: 'Home', icon: 'mdi-view-dashboard' },
          { title: 'About', icon: 'mdi-forum' },
        ],
  }),
  methods: {
    search(){
      console.log(this.searchText+"검색~");
    },
  },

}
</script>
<style lang="scss">
</style>