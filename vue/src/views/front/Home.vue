<template>
  <div class="main-content">
<!--    <div style="height: 60px; background-color: #c566f6ff"></div>-->
    <div>
      <img src="@/assets/imgs/carousel-3.png" alt="My Image">
    </div>
    <div style="display: flex">
      <!-- <div class="left"></div> -->
      <div style="width: 100%; background-color: white; margin-bottom: 50px">
        <div
          style="
            color: #fe0137ff;
            margin: 15px 0 15px 18px;
            font-weight: bold;
            font-size: 16px;
          "
        >
          电脑类别
        </div>
        <div style="display: flex; margin: 0 25px; height: 550px">
          <div style="padding-right: 30px">
            <div
              style="display: flex; color: #666666ff; margin: 14px 0"
              v-for="item in typeData"
              class="item-box"
            >
              <img :src="item.img" alt="" style="height: 20px; width: 20px" />
              <div style="margin-left: 10px; font-size: 14px">
                <a href="#" @click="navTo('/front/type?id=' + item.id)">{{
                  item.name
                }}</a>
              </div>
            </div>
          </div>
          <div style="flex: 5; margin-top: 0px">
            <div>
              <el-carousel height="600px" style="border-radius: 10px">
                <el-carousel-item v-for="item in carousel_top">
                  <img
                    :src="item"
                    alt=""
                    style="width: 100%; height: 600px; border-radius: 10px"
                  />
                </el-carousel-item>
              </el-carousel>
            </div>
            <!-- <div
              class="bottom-carousel"
              style="margin-top: 30px; display: flex; display: none"
            >
              <div style="flex: 1">
                <el-carousel height="300px" style="border-radius: 10px">
                  <el-carousel-item v-for="item in carousel_left">
                    <img
                      :src="item"
                      alt=""
                      style="width: 100%; height: 200px; border-radius: 10px"
                    />
                  </el-carousel-item>
                </el-carousel>
              </div>
              <div style="flex: 1; margin-left: 5px">
                <el-carousel height="300px" style="border-radius: 10px">
                  <el-carousel-item v-for="item in carousel_right">
                    <img
                      :src="item"
                      alt=""
                      style="width: 100%; height: 200px; border-radius: 10px"
                    />
                  </el-carousel-item>
                </el-carousel>
              </div>
            </div> -->
          </div>
          <!-- <div
            style="
              flex: 3;
              background-color: #f3f3f3ff;
              margin-top: 15px;
              margin-left: 15px;
              border-radius: 10px;
            "
          >
            <div style="text-align: center; margin-top: 30px">
              <img
                @click="navTo('/front/person')"
                :src="user.avatar"
                alt=""
                style="width: 80px; height: 80px; border-radius: 50%"
              />
              <div style="margin-top: 10px">Hi，{{ user.name }}</div>
            </div>
            <div style="margin-top: 20px; padding: 0 15px">
              <img
                src="@/assets/imgs/right.png"
                alt=""
                style="height: 150px; width: 100%; border-radius: 20px"
              />
            </div>
            <div
              style="
                margin: 20px 10px 10px 10px;
                width: 250px;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
              "
            >
              <i class="el-icon-bell"></i>
              <span style="font-weight: bold">公告</span>
              <span style="color: #666666">：{{ top }}</span>
            </div>
            <div style="display: flex; margin-top: 50px">
              <div style="flex: 1; text-align: center">
                <a href="#" @click="navTo('/front/collect')">
                  <img
                    src="@/assets/imgs/收藏.png"
                    alt=""
                    style="height: 25px; width: 25px"
                  />
                  <div>我的收藏</div>
                </a>
              </div>
              <div style="flex: 1; text-align: center">
                <a href="#" @click="navTo('/front/address')">
                  <img
                    src="@/assets/imgs/店铺.png"
                    alt=""
                    style="height: 25px; width: 25px"
                  />
                  <div>我的地址</div>
                </a>
              </div>
              <div style="flex: 1; text-align: center">
                <a href="#" @click="navTo('/front/cart')">
                  <img
                    src="@/assets/imgs/购物车.png"
                    alt=""
                    style="height: 25px; width: 25px"
                  />
                  <div>我的购物车</div>
                </a>
              </div>
              <div style="flex: 1; text-align: center">
                <a href="#" @click="navTo('/front/orders')">
                  <img
                    src="@/assets/imgs/订单.png"
                    alt=""
                    style="height: 25px; width: 25px"
                  />
                  <div>我的订单</div>
                </a>
              </div>
            </div>
          </div> -->
        </div>
        <div class="white-block"></div>
        <div
          style="
            margin: 5px 0 0 15px;
            height: 40px;
            background-color: #e11351;
            font-size: 20px;
            color: white;
            width: 130px;
            font-weight: bold;
            line-height: 40px;
            text-align: center;
            border-radius: 20px;
          "
        >
          商品一览
        </div>
        <div style="margin: 10px 5px 0 5px">
          <el-row>
            <el-col :span="5" v-for="item in goodsData">
              <img
                @click="navTo('/front/detail?id=' + item.id)"
                :src="item.img"
                alt=""
                style="
                  width: 100%;
                  height: 175px;
                  border-radius: 10px;
                  border: #cccccc 1px solid;
                "
              />
              <div
                style="
                  margin-top: 10px;
                  font-weight: 500;
                  font-size: 16px;
                  width: 180px;
                  color: #000000ff;
                  text-overflow: ellipsis;
                  overflow: hidden;
                  white-space: nowrap;
                "
              >
                {{ item.name }}
              </div>
              <div style="margin-top: 5px; font-size: 20px; color: #ff5000ff">
                ￥ {{ item.price }} / {{ item.unit }}
              </div>
            </el-col>
          </el-row>
        </div>
        <div
          style="
            margin: 40px 0 0 15px;
            height: 40px;
            background-color: #e11351;
            font-size: 20px;
            color: white;
            width: 130px;
            font-weight: bold;
            line-height: 40px;
            text-align: center;
            border-radius: 20px;
          "
        >
          热卖商品
        </div>
        <div style="margin: 10px 5px 0 5px">
          <el-row>
            <el-col :span="5" v-for="item in recommendData">
              <img
                @click="navTo('/front/detail?id=' + item.id)"
                :src="item.img"
                alt=""
                style="
                  width: 100%;
                  height: 175px;
                  border-radius: 10px;
                  border: #cccccc 1px solid;
                "
              />
              <div
                style="
                  margin-top: 10px;
                  font-weight: 500;
                  font-size: 16px;
                  width: 180px;
                  color: #000000ff;
                  text-overflow: ellipsis;
                  overflow: hidden;
                  white-space: nowrap;
                "
              >
                {{ item.name }}
              </div>
              <div style="margin-top: 5px; font-size: 20px; color: #ff5000ff">
                ￥ {{ item.price }} / {{ item.unit }}
              </div>
            </el-col>
          </el-row>
        </div>
      </div>
      <!-- <div class="right"></div> -->
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),
      typeData: [],
      top: null,
      notice: [],
      goodsData: [],
      recommendData: [],
      carousel_top: [
        require('@/assets/imgs/carousel-1.png'),
        require('@/assets/imgs/carousel-2.png'),
        require('@/assets/imgs/carousel-9.png'),
      ],
      carousel_left: [
        require('@/assets/imgs/carousel-3.png'),
        require('@/assets/imgs/carousel-4.png'),
        require('@/assets/imgs/carousel-5.png'),
      ],
      carousel_right: [
        require('@/assets/imgs/carousel-6.png'),
        require('@/assets/imgs/carousel-7.png'),
        require('@/assets/imgs/carousel-8.png'),
      ],
    };
  },
  mounted() {
    this.loadType();
    this.loadNotice();
    this.loadGoods();
    this.loadRecommend();
  },
  // methods：本页面所有的点击事件或者其他函数定义区
  methods: {
    loadRecommend() {
      this.$request.get('/goods/recommend').then((res) => {
        if (res.code === '200') {
          this.recommendData = res.data;
        } else {
          this.$message.error(res.msg);
        }
      });
    },
    loadType() {
      this.$request.get('/type/selectAll').then((res) => {
        if (res.code === '200') {
          this.typeData = res.data;
        } else {
          this.$message.error(res.msg);
        }
      });
    },
    loadNotice() {
      this.$request.get('/notice/selectAll').then((res) => {
        this.notice = res.data;
        let i = 0;
        if (this.notice && this.notice.length) {
          this.top = this.notice[0].content;
          setInterval(() => {
            this.top = this.notice[i].content;
            i++;
            if (i === this.notice.length) {
              i = 0;
            }
          }, 2500);
        }
      });
    },
    loadGoods() {
      this.$request.get('/goods/selectTop15').then((res) => {
        if (res.code === '200') {
          this.goodsData = res.data;
        } else {
          this.$message.error(res.msg);
        }
      });
    },
    navTo(url) {
      location.href = url;
    },
  },
};
</script>

<style scoped>
.item-box a:hover {
  border-bottom: 1px solid red;
  color: red;
}
img {
  display: block;
  object-fit: cover;
}
.main-content {
  min-height: 100vh;
  /*overflow: hidden;*/
  background-size: 100%;
  background-image: url('@/assets/imgs/img.png');
}
.left {
  width: 17%;
  background-repeat: no-repeat;
  background-image: url('@/assets/imgs/left-img.png');
}
.right {
  width: 17%;
  background-repeat: no-repeat;
  background-image: url('@/assets/imgs/right-img.png');
}
.el-col-5 {
  width: 20%;
  max-width: 20%;
  cursor: pointer;
  padding: 10px 10px;
}
</style>
<style>
.white-block {
  width: 400px; /* 设置宽度 */
  height: 200px; /* 设置高度 */
  background-color: white; /* 设置背景颜色为白色 */
}
</style>

