<template>
<!-- category 2 -->
	<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
		<view class="content">
			<view :style='{"minHeight":"100vh","alignContent":"flex-start","padding":"20rpx 20rpx 240rpx","alignItems":"flex-start","flexWrap":"wrap","background":"linear-gradient(135.00deg, rgb(206, 209, 242),rgb(228, 185, 225) 100%)","display":"flex","width":"100%","height":"auto"}'>
				<view class="cu-bar bg-white search" :style='{"width":"100%","padding":"0","background":"none","display":"flex","height":"auto"}'>
					<view :style='{"margin":"0 12rpx","flex":"1","position":"relative"}' class="search-form round">
						<text class="icon iconfont icon-fangdajing07" :style='{"color":"rgb(153, 153, 153)","left":"0px","textAlign":"center","width":"80rpx","fontSize":"40rpx","lineHeight":"80rpx","position":"absolute","right":"0px"}'></text>
						<input :style='{"border":"0","padding":"12rpx 20rpx 12rpx 80rpx","boxShadow":"inset 0px 2rpx 8rpx 0px rgb(131, 122, 161)","color":"#333","borderRadius":"40rpx","background":"#fff","width":"100%","lineHeight":"56rpx","fontSize":"28rpx","height":"80rpx"}' v-model="searchForm.keshimingcheng" type="text" placeholder="科室名称" ></input>
					</view>
					<button :style='{"border":"0","padding":"0px","margin":"0 0 0 -136rpx","color":"#000","borderRadius":"40rpx","background":"linear-gradient(90.00deg, rgb(228, 173, 215),rgb(188, 255, 253) 100%)","width":"136rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"relative","height":"80rpx","zIndex":"111"}' @tap="search" class="cu-btn shadow-blur round">搜索</button>
				</view>
			

				<view :style='{"padding":"10rpx","margin":"10rpx 0","borderRadius":"10rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%"}'>
					<view @click="sortClick('addtime')" :style='{"border":"2rpx solid #E4ADD7","padding":"0 12rpx","margin":"0 8rpx 0 0","outline":"0","borderRadius":"6rpx","background":"#F6F6FF","display":"flex"}'>
						<text :style='{"color":"#E4ADD7","lineHeight":"40rpx","fontSize":"24rpx"}'>按日期</text>
						<text v-if="listSort!='addtime'" class="icon iconfont icon-shijian18" :style='{"margin":"0 0 0 4rpx","lineHeight":"40rpx","fontSize":"24rpx","color":"#E4ADD7"}'></text>
						<text v-else-if="listSort=='addtime'&&listOrder=='asc'" class="icon iconfont icon-shijian18" :style='{"margin":"0 0 0 4rpx","lineHeight":"40rpx","fontSize":"24rpx","color":"#E4ADD7"}'></text>
						<text v-else-if="listSort=='addtime'&&listOrder=='desc'" class="icon iconfont icon-shijian18" :style='{"margin":"0 0 0 4rpx","lineHeight":"40rpx","fontSize":"24rpx","color":"#E4ADD7"}'></text>
					</view>
				</view>
				<view :style='{"alignContent":"flex-start","alignItems":"flex-start","flexWrap":"wrap","background":"none","display":"flex","width":"100%","height":"auto"}'>
					<scroll-view scroll-y="true" class="category-two" :style='{"width":"180rpx","padding":"10rpx","boxShadow":"inset 0px 2rpx 8rpx 0px rgb(131, 122, 161)","borderRadius":"10rpx","background":"#fff","height":"auto"}'>
						<view :class='categoryName === item.keshifenlei ? "active" : ""' class="tab" v-for="(item,index) in categoryList" :key="index" @tap="categoryClick(item.keshifenlei)">{{item.keshifenlei}}</view>
					</scroll-view>
			
			
					<!-- 样式4 -->
					<view v-if="list.length" class="list-box5" :style='{"width":"calc(100% - 180rpx)","padding":"0 0 20rpx 20rpx","margin":"0","flex":"1","height":"auto"}'>
						<block v-for="(product,index) in list" :key="index">
							<view v-if="index%2==0" class="list-item" :style='{"boxShadow":"inset 0px 2rpx 8rpx 0px rgb(131, 122, 161)","padding":"20rpx 0 20rpx 20rpx","margin":"0 0 20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","height":"auto"}'>
								<image :style='{"width":"200rpx","objectFit":"cover","display":"block","height":"160rpx"}' mode="aspectFill" v-if="preHttp(product.touxiang)" :src="product.touxiang"></image>
								<image :style='{"width":"200rpx","objectFit":"cover","display":"block","height":"160rpx"}' mode="aspectFill" v-else :src="product.touxiang?baseUrl+product.touxiang.split(',')[0]:''"></image>
					
								<view class="list-item-body" :style='{"padding":"0","margin":"0","flexWrap":"wrap","display":"flex","width":"calc(100% - 200rpx)","justifyContent":"space-between","height":"auto"}' @tap="onDetailTap(product)">
									<view :style='{"width":"100%","padding":"0 20rpx","margin":"0","lineHeight":"48rpx","fontSize":"28rpx","color":"#000"}' class="title">{{product.keshimingcheng}}</view>
									<view :style='{"width":"100%","padding":"0 20rpx","margin":"0","lineHeight":"48rpx","fontSize":"28rpx","color":"#000"}' class="title">{{product.keshifenlei}}</view>
									<view :style='{"width":"100%","padding":"0 20rpx","margin":"0","lineHeight":"48rpx","fontSize":"28rpx","color":"#000"}' class="title">{{product.yishengxingming}}</view>
									<view :style='{"width":"100%","padding":"0 20rpx","margin":"0","lineHeight":"48rpx","fontSize":"28rpx","color":"#000"}' class="title">专业:{{product.zhuanye}}</view>
									<view :style='{"padding":"0 20rpx","order":"1"}'>
										<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"40rpx","fontSize":"24rpx","color":"#B3B3B3"}'></text>
										<text :style='{"color":"#B3B3B3","lineHeight":"40rpx","fontSize":"24rpx"}'>{{product.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
									</view>
									<view :style='{"padding":"0 20rpx","display":"inline-block","order":"4"}'>
										<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"40rpx","fontSize":"24rpx","color":"#53B2FF"}'></text>
										<text :style='{"color":"#53B2FF","lineHeight":"40rpx","fontSize":"24rpx"}'>{{product.storeupnum}}</text>
									</view>
								</view>
								<!-- #ifdef MP-WEIXIN -->
								<view :style='{"width":"100%","padding":"8rpx 20rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
									<view :style='{"border":"2rpx solid #BCFFFD","padding":"0 16rpx","background":"#fff","display":"flex"}' v-if="(userid && isAuth('keshixinxi','修改')) || (!userid && isAuthFront('keshixinxi','修改'))" @tap.stop.proevent="onUpdate" :data-row="product">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"24rpx","lineHeight":"40rpx","color":"#E4B9E1","display":"inline-block"}' class="cuIcon-edit"></text>
										<text :style='{"fontSize":"24rpx","lineHeight":"40rpx","color":"#E4B9E1","display":"inline-block"}'>修改</text>
									</view>
									<view :style='{"border":"2rpx solid #E4AED7","padding":"0 16rpx","background":"#fff","display":"flex"}' v-if="(userid && isAuth('keshixinxi','删除')) || (!userid && isAuthFront('keshixinxi','删除'))" @tap.stop.proevent="onDelete" :data-row="product">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"24rpx","lineHeight":"40rpx","color":"#E4AED7","display":"inline-block"}' class="cuIcon-delete"></text>
										<text :style='{"fontSize":"24rpx","lineHeight":"40rpx","color":"#E4AED7","display":"inline-block"}'>删除</text>
									</view>
								</view>
								<!-- #endif -->
								<!-- #ifndef MP-WEIXIN -->
								<view :style='{"width":"100%","padding":"8rpx 20rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
									<view :style='{"border":"2rpx solid #BCFFFD","padding":"0 16rpx","background":"#fff","display":"flex"}' v-if="(userid && isAuth('keshixinxi','修改')) || (!userid && isAuthFront('keshixinxi','修改'))" @tap.stop.proevent="onUpdateTap(product)">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"24rpx","lineHeight":"40rpx","color":"#E4B9E1","display":"inline-block"}' class="cuIcon-edit"></text>
										<text :style='{"fontSize":"24rpx","lineHeight":"40rpx","color":"#E4B9E1","display":"inline-block"}'>修改</text>
									</view>
									<view :style='{"border":"2rpx solid #E4AED7","padding":"0 16rpx","background":"#fff","display":"flex"}' v-if="(userid && isAuth('keshixinxi','删除')) || (!userid && isAuthFront('keshixinxi','删除'))" @tap.stop.proevent="onDeleteTap(product.id)">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"24rpx","lineHeight":"40rpx","color":"#E4AED7","display":"inline-block"}' class="cuIcon-delete"></text>
										<text :style='{"fontSize":"24rpx","lineHeight":"40rpx","color":"#E4AED7","display":"inline-block"}'>删除</text>
									</view>
								</view>
								<!-- #endif -->
							</view>
							<view v-if="index%2==1" class="list-item" :style='{"boxShadow":"inset 0px 2rpx 8rpx 0px rgb(131, 122, 161)","padding":"20rpx 20rpx 20rpx 0","margin":"0 0 20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","height":"auto"}' @tap="onDetailTap(product)">
								<view class="list-item-body" :style='{"padding":"0","margin":"0","flexWrap":"wrap","display":"flex","width":"calc(100% - 200rpx)","justifyContent":"space-between","height":"auto"}'>
									<view :style='{"width":"100%","padding":"0 20rpx","margin":"0","lineHeight":"48rpx","fontSize":"28rpx","color":"#000"}' class="title">{{product.keshimingcheng}}</view>
									<view :style='{"width":"100%","padding":"0 20rpx","margin":"0","lineHeight":"48rpx","fontSize":"28rpx","color":"#000"}' class="title">{{product.keshifenlei}}</view>
									<view :style='{"width":"100%","padding":"0 20rpx","margin":"0","lineHeight":"48rpx","fontSize":"28rpx","color":"#000"}' class="title">{{product.yishengxingming}}</view>
									<view :style='{"width":"100%","padding":"0 20rpx","margin":"0","lineHeight":"48rpx","fontSize":"28rpx","color":"#000"}' class="title">专业:{{product.zhuanye}}</view>
									<view :style='{"padding":"0 20rpx","order":"1"}'>
										<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"40rpx","fontSize":"24rpx","color":"#B3B3B3"}'></text>
										<text :style='{"color":"#B3B3B3","lineHeight":"40rpx","fontSize":"24rpx"}'>{{product.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
									</view>
									<view :style='{"padding":"0 20rpx","display":"inline-block","order":"4"}'>
										<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"40rpx","fontSize":"24rpx","color":"#53B2FF"}'></text>
										<text :style='{"color":"#53B2FF","lineHeight":"40rpx","fontSize":"24rpx"}'>{{product.storeupnum}}</text>
									</view>
								</view>
					
								<image :style='{"width":"200rpx","objectFit":"cover","display":"block","height":"160rpx"}' mode="aspectFill" v-if="preHttp(product.touxiang)" :src="product.touxiang"></image>
								<image :style='{"width":"200rpx","objectFit":"cover","display":"block","height":"160rpx"}' mode="aspectFill" v-else :src="product.touxiang?baseUrl+product.touxiang.split(',')[0]:''"></image>
					
								<!-- #ifdef MP-WEIXIN -->
								<view :style='{"width":"100%","padding":"8rpx 20rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
									<view :style='{"border":"2rpx solid #BCFFFD","padding":"0 16rpx","background":"#fff","display":"flex"}' v-if="(userid && isAuth('keshixinxi','修改')) || (!userid && isAuthFront('keshixinxi','修改'))" @tap.stop.proevent="onUpdate" :data-row="product">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"24rpx","lineHeight":"40rpx","color":"#E4B9E1","display":"inline-block"}' class="cuIcon-edit"></text>
										<text :style='{"fontSize":"24rpx","lineHeight":"40rpx","color":"#E4B9E1","display":"inline-block"}'>修改</text>
									</view>
									<view :style='{"border":"2rpx solid #E4AED7","padding":"0 16rpx","background":"#fff","display":"flex"}' v-if="(userid && isAuth('keshixinxi','删除')) || (!userid && isAuthFront('keshixinxi','删除'))" @tap.stop.proevent="onDelete" :data-row="product">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"24rpx","lineHeight":"40rpx","color":"#E4AED7","display":"inline-block"}' class="cuIcon-delete"></text>
										<text :style='{"fontSize":"24rpx","lineHeight":"40rpx","color":"#E4AED7","display":"inline-block"}'>删除</text>
									</view>
								</view>
								<!-- #endif -->
								<!-- #ifndef MP-WEIXIN -->
								<view :style='{"width":"100%","padding":"8rpx 20rpx 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
									<view :style='{"border":"2rpx solid #BCFFFD","padding":"0 16rpx","background":"#fff","display":"flex"}' v-if="(userid && isAuth('keshixinxi','修改')) || (!userid && isAuthFront('keshixinxi','修改'))" @tap.stop.proevent="onUpdateTap(product)">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"24rpx","lineHeight":"40rpx","color":"#E4B9E1","display":"inline-block"}' class="cuIcon-edit"></text>
										<text :style='{"fontSize":"24rpx","lineHeight":"40rpx","color":"#E4B9E1","display":"inline-block"}'>修改</text>
									</view>
									<view :style='{"border":"2rpx solid #E4AED7","padding":"0 16rpx","background":"#fff","display":"flex"}' v-if="(userid && isAuth('keshixinxi','删除')) || (!userid && isAuthFront('keshixinxi','删除'))" @tap.stop.proevent="onDeleteTap(product.id)">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"24rpx","lineHeight":"40rpx","color":"#E4AED7","display":"inline-block"}' class="cuIcon-delete"></text>
										<text :style='{"fontSize":"24rpx","lineHeight":"40rpx","color":"#E4AED7","display":"inline-block"}'>删除</text>
									</view>
								</view>
								<!-- #endif -->
							</view>
						</block>
					</view>
			


			
			
			
			
				</view>
				<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx #00000030","color":"#000","bottom":"128rpx","outline":"none","borderRadius":"100%","left":"20rpx","background":"linear-gradient(90.00deg, rgb(228, 173, 215),rgb(188, 255, 253) 100%)","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"fixed","height":"80rpx","zIndex":"999"}' class="add-btn" @click="screenBoxShow=true">筛</button>
				<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","color":"#000","bottom":"128rpx","right":"128rpx","outline":"none","borderRadius":"100%","background":"linear-gradient(90.00deg, rgb(228, 173, 215),rgb(188, 255, 253) 100%)","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"fixed","height":"80rpx","zIndex":"999"}' v-if="userid && isAuth('keshixinxi','新增')" class="add-btn" @click="onAddTap()">新增</button>
				<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","color":"#000","bottom":"128rpx","right":"128rpx","outline":"none","borderRadius":"100%","background":"linear-gradient(90.00deg, rgb(228, 173, 215),rgb(188, 255, 253) 100%)","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"fixed","height":"80rpx","zIndex":"999"}' v-if="!userid && isAuthFront('keshixinxi','新增')" class="add-btn" @click="onAddTap()">新增</button>
				<view :style='{"top":"0","left":"0","background":"rgba(0, 0, 0, .3)","width":"100%","position":"absolute","height":"100%","zIndex":"665"}' v-if="screenBoxShow" @click="screenBoxShow=false"></view>
				<view class="screenBox" :class="screenBoxShow?'screenBoxActive':''">
					<view :style='{"width":"100%","padding":"20rpx 0 20rpx 0","alignItems":"center","flexWrap":"wrap","justifyContent":"space-around","display":"flex"}'>
						<view :style='{"width":"100%","padding":"0 0 20rpx 20rpx","fontSize":"26rpx","color":"#858585"}'>医生姓名</view>
						<input :style='{"border":"2rpx solid rgb(214, 214, 214)","width":"90%","padding":"0 20rpx 0 20rpx","borderRadius":"4rpx","background":"#F8F8F8","height":"64rpx"}' placeholder="请输入医生姓名" v-model="searchForm.yishengxingming">
					</view>
					<view :style='{"width":"100%","padding":"40rpx 0 0 20rpx","alignItems":"center","justifyContent":"flex-start","display":"flex"}'>
						<div :style='{"margin":"0 20rpx 0 0","color":"#999898","textAlign":"center","background":"#EDEDED","width":"30%","lineHeight":"60rpx","height":"60rpx"}' @click="screenReset">重置</div>
						<div :style='{"width":"30%","lineHeight":"60rpx","color":"#000","textAlign":"center","background":"#BDFDFC","height":"60rpx"}' @click="search">搜索</div>
					</view>
				</view>
			</view>
		</view>
	</mescroll-uni>
</template>

<script>
	export default {
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				list: [],
				lists: [],
                userid: '',
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 5, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				searchForm:{
					keshimingcheng: '',
					yishengxingming: '',
				},
				categoryList:[],
				categoryName :'全部',
				CustomBar: '0',
				listSort: 'id',
				listOrder: 'desc',
				screenBoxShow: false,
			};
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
		async onShow() {
            if(uni.getStorageSync("useridTag")==1){
                this.userid=uni.getStorageSync("useridTag");
                uni.removeStorageSync("useridTag");
            } else {
                this.userid = "";
            }
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
            let res = {};
            if(this.userid) {
                res = await this.$api.page('keshifenlei', {page:1,limit:100});
            } else {
                res = await this.$api.list('keshifenlei', {page:1,limit:100});
            }
			res.data.list.splice(0,0,{id:0,keshifenlei:'全部'})
			this.categoryList = res.data.list;
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		async onLoad(options) {
            if(uni.getStorageSync("useridTag")==1){
                this.userid=uni.getStorageSync("useridTag");
                uni.removeStorageSync("useridTag");
            } else {
                this.userid = "";
            }
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		components: {
		},
		methods: {
			screenReset(){
				this.searchForm = {}
				this.$forceUpdate()
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
			sortClick(type){
				if(this.listSort==type){
					if(this.listOrder == 'desc'){
						this.listOrder = 'asc'
					}else{
						this.listOrder = 'desc'
					}
				}else{
					this.listSort = type
					this.listOrder = 'desc'
				}
				this.search()
			},
            priceChange(price) {
                return Number(price).toFixed(2);
            },
            preHttp(str) {
                return str && str.substr(0,4)=='http';
            },
			//类别搜索
			categoryClick(categoryName){
				this.categoryName = categoryName;
				this.mescroll.resetUpScroll();
			},
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},
			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				// 重置分页参数页数为1
				mescroll.resetUpScroll()
			},
			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let params = {
					page: mescroll.num,
					limit: mescroll.size,
				}
				params['sort'] = this.listSort;
				params['order'] = this.listOrder;

				if(this.categoryName!='全部'){
					params.keshifenlei = '%' + this.categoryName + '%'
				}
				if(this.searchForm.keshimingcheng){
					params['keshimingcheng'] = '%' + this.searchForm.keshimingcheng + '%'
				}
				if(this.searchForm.yishengxingming){
					params['yishengxingming'] = '%' + this.searchForm.yishengxingming + '%'
				}
				let user = uni.getStorageSync("appUserid")?JSON.parse(uni.getStorageSync('userSession')):{}
                let res = {}
                if(this.userid) {
                    res = await this.$api.page(`keshixinxi`, params);
                } else {
                    res = await this.$api.list(`keshixinxi`, params);
                }

				// 如果是第一页数据置空
				if (mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				this.$forceUpdate()
				
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);
			},
			// 详情
			onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
			},
			onUpdate(e){
				this.onUpdateTap(e.currentTarget.dataset.row)
			},
			// 修改
			onUpdateTap(row){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update?id=${row.id}`)
			},
			// 添加
			onAddTap(){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update`)
			},
			onDelete(e){
				this.onDeleteTap(e.currentTarget.dataset.row.id)
			},
			onDeleteTap(id){
				var _this = this;
				uni.showModal({
					title: '提示',
					content: '是否确认删除',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.del('keshixinxi', JSON.stringify([id]));
							let obj = await _this.$api.list('storeup',{
								page: 1,
								limit: 100,
								tablename: 'keshixinxi',
								refid: id,
							})
							if(obj.data.list.length){
								let arr = []
								for(let x in obj.data.list){
									arr.push(obj.data.list[x].id)
								}
								await _this.$api.del('storeup',JSON.stringify(arr))
							}
							_this.$utils.msg('删除成功');
							_this.hasNext = true
							// 重置分页参数页数为1
							_this.search()
						}
					}
				});
			},
			// 搜索
			async search(){
				this.mescroll.num = 1
				let searchForm = {
					page: this.mescroll.num,
					limit: this.mescroll.size,
				}
				searchForm['sort'] = this.listSort;
				searchForm['order'] = this.listOrder;

				if(this.searchForm.keshimingcheng){
					searchForm['keshimingcheng'] = '%' + this.searchForm.keshimingcheng + '%'
				}
				if(this.categoryName!='全部'){
					searchForm.keshifenlei = '%' + this.categoryName + '%'
				}
				if(this.searchForm.yishengxingming){
					searchForm['yishengxingming'] = '%' + this.searchForm.yishengxingming + '%'
				}
                let res = {};
                if(this.userid) {
                    res = await this.$api.page(`keshixinxi`, searchForm);
                } else {
                    res = await this.$api.list(`keshixinxi`, searchForm);
                }
				// 如果是第一页数据置空
				if (this.mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				this.mescroll.endSuccess(this.mescroll.size, this.hasNext);
				this.screenBoxShow = false
			}
		}
	};
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	.category-two .tab {
		cursor: pointer;
		padding: 0 0 0 10rpx;
		margin: 0 0 20rpx;
		color: #D6D6D6;
		background: none;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 50rpx;
		text-align: left;
	}
	
	.category-two .tab.active {
		cursor: pointer;
		padding: 0 0 0 10rpx;
		box-shadow: inset 0px 2rpx 8rpx 0px rgb(131, 122, 161);
		margin: 0 0 20rpx;
		color: #E4ADD7;
		background: #F6F6FF;
		display: inline-block;
		width: 100%;
		font-size: 26rpx;
		line-height: 50rpx;
		text-align: left;
	}
	.screenBox {
		border-radius: 40rpx 0 0 40rpx;
		padding: 20rpx 0 20rpx 0;
		transform: translate3d(100%, 0, 0);
		z-index: 666;
		top: 0;
		background: #fff;
		width: 80%;
		position: absolute;
		right: 0;
		transition: transform .3s;
		height: 100%;
		.screenTab {
			border: 2rpx solid #D6D6D6;
			border-radius: 4rpx;
			margin: 10rpx 0 10rpx 0;
			color: #D6D6D6;
			background: #F8F8F8;
			width: calc(100% / 3 - 24rpx);
			line-height: 60rpx;
			text-align: center;
		}
		.screenTabActive {
			border-radius: 4rpx;
			margin: 10rpx 0 10rpx 0;
			color: #000;
			background: linear-gradient(135.00deg, rgb(228, 173, 215) 0%,rgb(188, 255, 253) 100%);
			width: calc(100% / 3 - 20rpx);
			line-height: 60rpx;
			text-align: center;
		}
	}
	.screenBoxActive {
		transform: translate3d(0, 0, 0);
	}
</style>
