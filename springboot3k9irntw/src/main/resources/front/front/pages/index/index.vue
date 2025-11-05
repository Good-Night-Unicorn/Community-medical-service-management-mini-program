<template>
	<view class="content">
		<view :style='{"width":"100%","padding":"20rpx","flexWrap":"wrap","background":"linear-gradient(135.00deg, rgb(206, 209, 242),rgb(228, 185, 225) 100%)","display":"flex","height":"auto"}'>
			<z-swiper v-model="swiperList" :options="options2" :style='{"width":"100%","margin":"0 0 20rpx","background":"none","height":"280rpx","order":"2"}' style="touch-action: none;">
				<z-swiper-item style="touch-action: none;" :style='{"width":"100%","background":"none","height":"280rpx"}' v-for="(swiper,index) in swiperList" :key="index" @tap="onSwiperTap(swiper)">
					<image :style='{"width":"100%","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"280rpx"}' mode="aspectFill" :src="baseUrl+swiper.img"></image>
					<view v-if="false" :style='{"width":"100%","padding":"0 8rpx","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","background":"#fff"}'>{{ swiper.title }}</view>
				</z-swiper-item>
			</z-swiper>
			<!-- menu -->
			<view v-if="true" class="menu_view">
				<block v-for="(item,index1) in menuList" v-bind:key="item.roleName">
					<block v-if="index1==0" v-bind:key="index" v-for=" (menu,index) in item.frontMenu">
						<block v-bind:key="sort" v-for=" (child,sort) in menu.child">
							<block v-bind:key="sort2" v-for=" (button,sort2) in child.buttons">
								<view class="menu-item" v-if="button=='查看' && child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' " @tap="onPageTap2(child.tableName)">
									<view class="iconarr" :class="child.appFrontIcon" :style="{'background':menuColor[index]}"></view>
									
									<view class="text">{{child.menu.split("列表")[0]}}</view>
								</view>
							</block>
						</block>
					</block>
				</block>
			</view>
			<!-- 商品推荐 -->
			<!-- 商品推荐 -->
			
			<!-- 商品列表 -->
			<!-- 商品列表 -->
			<!-- 新闻资讯 -->
			<view class="listBox news" :style='{"width":"100%","margin":"0 0 20rpx","borderRadius":"20rpx","background":"#fff","order":"9"}'>
				<view class="title" :style='{"padding":"0 24rpx","margin":"0","alignItems":"flex-end","background":"url(http://codegen.caihongy.cn/20241221/0ebb643a369e49a0a77f104f2e7cf918.png) center center/100% 100%","display":"flex","width":"100%","justifyContent":"space-between","height":"80rpx"}'>
					<view :style='{"padding":"0 0 0 60rpx","fontSize":"36rpx","lineHeight":"60rpx","color":"#E4B9E1","fontWeight":"bold"}'>公告信息</view>
					<view :style='{"padding":"0 20rpx","boxShadow":"0px 2rpx 8rpx 0px rgb(204, 208, 241)","margin":"0 0 8rpx","alignItems":"center","borderRadius":"8rpx","background":"#BDFDFC","display":"flex","justifyContent":"center"}' @tap="onPageTap('news')">
					  <text :style='{"color":"#000","fontSize":"24rpx","lineHeight":"44rpx"}'>更多</text>
					  <text class="icon iconfont icon-gengduo1" :style='{"color":"#000","fontSize":"24rpx","lineHeight":"44rpx"}'></text>
					</view>
				</view>
				<!-- 样式2 -->
				<view class="list-box style2" :style='{"width":"100%","padding":"24rpx","height":"auto"}'>
					<view class="tabView" :style='{"width":"100%","flexWrap":"wrap","justifyContent":"center","display":"flex"}'>
						<view class="tab" :class="newsIndex2==index?'tabActive':''" v-for="(item,index) in newsCateList2" :key="index" @click="newsTabClick2(index)">
							<text class="icon iconfont icon-zhankai19" :style='{"margin":"0 4rpx 0 0","lineHeight":"68rpx","fontSize":"28rpx","color":"inherit"}'></text>
							<text :style='{"color":"inherit","lineHeight":"68rpx","fontSize":"28rpx"}'>{{item.typename}}</text>
						</view>
					</view>
					<view :style='{"width":"100%","background":"#fff"}'>
						<view @tap="onNewsDetailTap(item.id)" v-for="(item,index) in news" :key="index" class="list-item" :style='{"width":"100%","padding":"20rpx 0","borderColor":"#E4ADD7","borderStyle":"solid","borderWidth":"0 0 4rpx 0","display":"flex"}'>
							<view :style='{"alignItems":"center","color":"#fff","borderRadius":"20rpx","background":"linear-gradient(-45.00deg, rgb(188, 255, 253) 0%,rgb(225, 188, 227) 100%)","flexDirection":"column","display":"flex","width":"176rpx","fontSize":"28rpx","justifyContent":"center"}'>
								<view :style='{"color":"#fff","fontSize":"48rpx","lineHeight":"1.5"}'>{{item.addtime.split(" ")[0].split("-")[2]}}</view>
								<view :style='{"fontSize":"28rpx","lineHeight":"1.5","color":"#fff","fontWeight":"bold"}'>{{item.addtime.split(" ")[0].split("-")[0]}}-{{item.addtime.split(" ")[0].split("-")[1]}}</view>
							</view>
							<view class="list-item-body" :style='{"width":"calc(100% - 176rpx)","padding":"0","flexWrap":"wrap","flex":"1","display":"flex"}'>
								<view :style='{"padding":"0 20rpx","margin":"0","whiteSpace":"nowrap","overflow":"hidden","color":"#292929","width":"100%","lineHeight":"60rpx","fontSize":"28rpx","textOverflow":"ellipsis"}' class="title">{{item.title}}</view>
								<view :style='{"padding":"0 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#AEAEAE","width":"100%","lineHeight":"50rpx","fontSize":"24rpx","textOverflow":"ellipsis"}' class="text">{{item.introduction}}</view>
								<view :style='{"padding":"0 20rpx","order":"4"}'>
									<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"40rpx","fontSize":"24rpx","color":"#8FA771"}'></text>
									<text :style='{"color":"#8FA771","lineHeight":"40rpx","fontSize":"24rpx"}'>{{item.name}}</text>
								</view>
								<view :style='{"padding":"0 20rpx","display":"inline-block","order":"1"}'>
									<text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"40rpx","fontSize":"24rpx","color":"#CAAEFF"}'></text>
									<text :style='{"color":"#CAAEFF","lineHeight":"40rpx","fontSize":"24rpx"}'>{{item.thumbsupnum}}</text>
								</view>
								<view :style='{"padding":"0 20rpx","display":"inline-block","order":"2"}'>
									<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"40rpx","fontSize":"24rpx","color":"#53B2FF"}'></text>
									<text :style='{"color":"#53B2FF","lineHeight":"40rpx","fontSize":"24rpx"}'>{{item.storeupnum}}</text>
								</view>
								<view :style='{"padding":"0 20rpx","display":"inline-block","order":"3"}'>
									<text class="icon iconfont icon-chakan9" :style='{"margin":"0 4rpx 0 0","lineHeight":"40rpx","fontSize":"24rpx","color":"#FC6363"}'></text>
									<text :style='{"color":"#FC6363","lineHeight":"40rpx","fontSize":"24rpx"}'>{{item.clicknum}}</text>
								</view>
							</view>
						</view>
					</view>
				</view>
			</view>
			<!-- 新闻资讯 -->
			<view v-if="scrollTop>200" @tap="scrollTopClick" :style='{"boxShadow":"0 8rpx 16rpx rgba(0,0,0,.3)","borderRadius":"50%","textAlign":"center","bottom":"20%","background":"#ff000030","width":"60rpx","lineHeight":"60rpx","position":"fixed","right":"20rpx","height":"60rpx"}'>
				<span class="icon iconfont icon-jiantou07" :style='{"color":"#fff"}'></span>
			</view>
		</view>
	</view>
</template>

<script>
    import menu from '@/utils/menu'
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				options2: {
					effect: 'flip',
					loop : true
				},
				options3: {
					effect: 'cube',
					loop : true,
					cubeEffect: {
						shadow: true,
						slideShadows: true,
						shadowOffset: 20,
						shadowScale: 0.94,
					}
				},
				rows: 2,
				column: 4,
				iconArr: [
					'cuIcon-same',
					'cuIcon-deliver',
					'cuIcon-evaluate',
					'cuIcon-shop',
					'cuIcon-ticket',
					'cuIcon-cascades',
					'cuIcon-discover',
					'cuIcon-question',
					'cuIcon-pic',
					'cuIcon-filter',
					'cuIcon-footprint',
					'cuIcon-pulldown',
					'cuIcon-pullup',
					'cuIcon-moreandroid',
					'cuIcon-refund',
					'cuIcon-qrcode',
					'cuIcon-remind',
					'cuIcon-profile',
					'cuIcon-home',
					'cuIcon-message',
					'cuIcon-link',
					'cuIcon-lock',
					'cuIcon-unlock',
					'cuIcon-vip',
					'cuIcon-weibo',
					'cuIcon-activity',
					'cuIcon-friendadd',
					'cuIcon-friendfamous',
					'cuIcon-friend',
					'cuIcon-goods',
					'cuIcon-selection'
				],
				role : '',
				menuList: [],
				swiperMenuList:[],
				user: {},
				tableName:'',
				menuColor: '#E4ADD7,#BCFFFD,#E5CCCF,#B9EAE7,#E8909D,#C090C9,#76E4DC,#F8D8DD,#BDFDFC,#FC6363,#53B2FF,#CAAEFF'.split(','),

				//轮播
				swiperList: [],
				news: [],
				newsCateList2: [],
				newsIndex2: 0,
				scrollTop: 0,
			}
		},
		onPageScroll(e) {
			this.scrollTop = e.scrollTop
		},
		watch: {
		},
		mounted() {
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(){
			this.menuColor = this.menuColor.sort(()=> {
				return (0.5-Math.random());
			});
		},
		async onShow() {
			this.swiperMenuList = []
			this.role = uni.getStorageSync("appRole");
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.user = res.data;
			this.tableName = table;
			let menus = menu.list();
			this.menuList = menus;
			this.menuList.forEach((item,key) => {
				if(key==0) {
					item.frontMenu.forEach((item2,key2) => {
						if(item2.child[0].buttons.indexOf("查看")>-1) {
							this.swiperMenuList.push(item2);
						}
					})
				}
			})
			// let res;
			// 轮播图
			let swiperList = []
			res = await this.$api.list('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					swiperList.push({
						img: item.value,
						title: item.name,
						url: item.url
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
			

			if(uni.getStorageSync("appUserid")) {
				res = await this.$api.page('newstype', {page:1,limit:100});
			} else {
				res = await this.$api.list('newstype', {page:1,limit:100});
			}
			res.data.list.splice(0,0,{id:0,typename:'全部'})
			this.newsIndex2 = 0
			this.newsCateList2 = res.data.list
			this.getRecommendList()
			this.getHomeList()
			this.getNewsList()
		},
		methods: {
			scrollTopClick(){
				uni.pageScrollTo({
					scrollTop: 0
				})
			},
			uGetRect(selector, all) {
				return new Promise(resolve => {
					uni.createSelectorQuery()
					.in(this)
					[all ? 'selectAll' : 'select'](selector)
					.boundingClientRect(rect => {
						if (all && Array.isArray(rect) && rect.length) {
							resolve(rect);
						}
						if (!all && rect) {
							resolve(rect);
						}
					})
					.exec();
				});
			},
			cloneData(data) {
				return JSON.parse(JSON.stringify(data));
			},
			newsTabClick2(index){
				this.newsIndex2 = index
				this.getNewsList()
			},
			async getNewsList(){
				let res;
				let params = {
					page: 1,
					limit: 6,
					sort: 'id',
					order: 'desc',
				}
				if(this.newsIndex2){
					params.typename = this.newsCateList2[this.newsIndex2].typename
				}
				// 公告信息
				res = await this.$api.list('news', params)
				this.news = res.data.list
			},
			homeTabClick2(index,name){
				this['home' + name + 'Index2'] = index
				this.getHomeList()
			},
			async getHomeList(){
				let res;
				let params;
			},
			recommendTabClick2(index,name){
				this[name + 'Index2'] = index
				this.getRecommendList()
			},
			async getRecommendList(){
				let res;
				let params;
			},
			//轮播图跳转
			onSwiperTap(e) {
				if(e.url) {
					if (e.url.indexOf('https') != -1) {
						// #ifdef MP-WEIXIN
						uni.navigateTo({
						    url: '../../common/linkOthers/linkOthers?url=' + encodeURIComponent(e.url),
						});
						return false
						// #endif
						window.open(e.url)
					} else {
						this.$utils.jump(e.url)
					}
				}
			},
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){
				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			},
			onPageTap2(index) {
				let url = '../' + index + '/list'
				if(index=='forum'){
					url = '../forum-index/forum-index'
				}
				uni.setStorageSync("useridTag",0);
				uni.navigateTo({
					url: url,
					fail: function() {
						uni.switchTab({
							url: url
						});
					}
				});
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}

	.news {
		.style2 {
			.tabView {
				.tab {
					border: 2rpx solid #D6D6D6;
					border-radius: 0;
					padding: 0 20rpx;
					margin: 0 10rpx;
					color: #D6D6D6;
					background: #fff;
					border-width: 0 0 4rpx;
				}
				.tabActive {
					border: 2rpx solid #E1BCE3;
					border-radius: 0;
					padding: 0 20rpx;
					margin: 0 10rpx;
					color: #E4B9E1;
					background: #FEF3FF;
					border-width: 0 0 4rpx;
				}
			}
		}
	}
	.menu_view {
		border-radius: 20rpx;
		padding: 0;
		margin: 0 0 20rpx;
		background: #fff;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		flex-wrap: wrap;
		height: auto;
		order: 3;
		.menu-item {
			padding: 12rpx 0;
			margin: 10rpx 1%;
			width: 23%;
			height: auto;
			.iconarr {
				border-radius: 10rpx;
				padding: 0;
				margin: 0px auto;
				color: #fff;
				background: #fff;
				display: block;
				width: 80rpx;
				font-size: 48rpx;
				line-height: 80rpx;
				text-align: center;
				height: 80rpx;
			}
			.text {
				padding: 0;
				margin: 12rpx auto 0;
				color: #333;
				width: 100%;
				font-size: 28rpx;
				line-height: 28rpx;
				text-align: center;
			}
		}
	}
</style>
