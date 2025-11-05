<template>
<view class="content">
	<view :style='{"minHeight":"100%","padding":"20rpx","alignItems":"flex-start","background":"linear-gradient(135.00deg, rgb(206, 209, 242),rgb(228, 185, 225) 100%)","display":"flex","width":"100%","height":"auto"}'>
		<form :style='{"width":"100%","padding":"24rpx","borderRadius":"20rpx","background":"#fff","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">科室名称</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"70rpx"}' :disabled="ro.keshimingcheng" v-model="ruleForm.keshimingcheng" placeholder="科室名称"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">科室分类</view>
				<picker :disabled="ro.keshifenlei" :style='{"width":"100%","flex":"1","height":"auto"}' @change="keshifenleiChange" :value="keshifenleiIndex" :range="keshifenleiOptions">
					<view :style='{"width":"100%","padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#D4C1D6"}' class="uni-input">{{ruleForm.keshifenlei?ruleForm.keshifenlei:"请选择科室分类"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="" @tap="touxiangTap">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">头像</view>
				<image :style='{"width":"80rpx","margin":"0 0 0 20rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.touxiang" :src="baseUrl+ruleForm.touxiang.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","margin":"0 0 0 20rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">挂号费</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"70rpx"}' :disabled="ro.guahaofei" v-model.number="ruleForm.guahaofei" placeholder="挂号费" type="number"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">取消时间</view>
				<input :disabled="ro.quxiaoshijian" :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"70rpx"}' v-model="ruleForm.quxiaoshijian" placeholder="取消时间" @tap="toggleTab('quxiaoshijian')"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">医生账号</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"70rpx"}' :disabled="ro.yishengzhanghao" v-model="ruleForm.yishengzhanghao" placeholder="医生账号"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">医生姓名</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"70rpx"}' :disabled="ro.yishengxingming" v-model="ruleForm.yishengxingming" placeholder="医生姓名"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">专业</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"70rpx"}' :disabled="ro.zhuanye" v-model="ruleForm.zhuanye" placeholder="专业"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">患者账号</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"70rpx"}' :disabled="ro.huanzhezhanghao" v-model="ruleForm.huanzhezhanghao" placeholder="患者账号"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">患者姓名</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"70rpx"}' :disabled="ro.huanzhexingming" v-model="ruleForm.huanzhexingming" placeholder="患者姓名"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">患者电话</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"70rpx"}' :disabled="ro.huanzhedianhua" v-model="ruleForm.huanzhedianhua" placeholder="患者电话"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">年龄</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"70rpx"}' :disabled="ro.nianling" v-model="ruleForm.nianling" placeholder="年龄"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">医保卡号</view>
				<input :style='{"border":"0","padding":"0px 20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"70rpx"}' :disabled="ro.yibaokahao" v-model="ruleForm.yibaokahao" placeholder="医保卡号"  type="text"></input>
			</view>
                 
			<view :style='{"padding":"12rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"70rpx","fontSize":"28rpx","color":"#000","textAlign":"right"}' class="title">取消原因</view>
				<textarea :style='{"border":"0","padding":"20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"240rpx"}' v-model="ruleForm.quxiaoyuanyin" placeholder="取消原因" :maxlength="-1"></textarea>
			</view>
			
			<view :style='{"padding":"20rpx 0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"center","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0px","margin":"0 0 20rpx","color":"rgb(255, 255, 255)","background":"#E4AED7","width":"100%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

		<w-picker  mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="quxiaoshijianConfirm" ref="quxiaoshijian" themeColor="#333333"></w-picker>
	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
	import xiaEditor from '@/components/xia-editor/xia-editor';
	import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				keshimingcheng: '',
				keshifenlei: '',
				touxiang: '',
				guahaofei: '',
				quxiaoshijian: '',
				quxiaoyuanyin: '',
				yishengzhanghao: '',
				yishengxingming: '',
				zhuanye: '',
				huanzhezhanghao: '',
				huanzhexingming: '',
				huanzhedianhua: '',
				nianling: '',
				yibaokahao: '',
				shhf: '',
				ispay: '',
				},
				keshifenleiOptions: [],
				keshifenleiIndex: 0,
				// 登录用户信息
				user: {},
				ro:{
				   keshimingcheng : false,
				   keshifenlei : false,
				   touxiang : false,
				   guahaofei : false,
				   quxiaoshijian : false,
				   quxiaoyuanyin : false,
				   yishengzhanghao : false,
				   yishengxingming : false,
				   zhuanye : false,
				   huanzhezhanghao : false,
				   huanzhexingming : false,
				   huanzhedianhua : false,
				   nianling : false,
				   yibaokahao : false,
				   sfsh : false,
				   shhf : false,
				   ispay : false,
				},
				virtualPay: false,
			}
		},
		components: {
			wPicker,
			xiaEditor,
			multipleSelect,
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},



		},
		async onLoad(options) {
			if(options.virtualPay){
				this.virtualPay = true
			}
			this.ruleForm.quxiaoshijian =  this.$utils.getCurDateTime();
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取
			this.ruleForm.huanzhezhanghao = this.user.huanzhezhanghao
			this.ro.huanzhezhanghao = true;
			this.ruleForm.huanzhexingming = this.user.huanzhexingming
			this.ro.huanzhexingming = true;
			this.ruleForm.huanzhedianhua = this.user.huanzhedianhua
			this.ro.huanzhedianhua = true;
			this.ruleForm.nianling = this.user.nianling
			this.ro.nianling = true;

			this.ro.guahaofei = true;

			// 下拉框
			res = await this.$api.option(`keshifenlei`,`keshifenlei`,{});
			this.keshifenleiOptions = res.data;
			this.keshifenleiOptions.unshift("请选择科室分类");

			// 如果有登录，获取登录后保存的userid
			this.ruleForm.userid = uni.getStorageSync("appUserid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = Number(options.refid);
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`quxiaoguahao`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='keshimingcheng'){
						this.ruleForm.keshimingcheng = obj[o];
						this.ro.keshimingcheng = true;
						continue;
					}
					if(o=='keshifenlei'){
						this.ruleForm.keshifenlei = obj[o];
						this.ro.keshifenlei = true;
						continue;
					}
					if(o=='touxiang'){
						this.ruleForm.touxiang = obj[o].split(",")[0];
						this.ro.touxiang = true;
						continue;
					}
					if(o=='guahaofei'){
						this.ruleForm.guahaofei = obj[o];
						this.ro.guahaofei = true;
						continue;
					}
					if(o=='quxiaoshijian'){
						this.ruleForm.quxiaoshijian = obj[o];
						this.ro.quxiaoshijian = true;
						continue;
					}
					if(o=='quxiaoyuanyin'){
						this.ruleForm.quxiaoyuanyin = obj[o];
						this.ro.quxiaoyuanyin = true;
						continue;
					}
					if(o=='yishengzhanghao'){
						this.ruleForm.yishengzhanghao = obj[o];
						this.ro.yishengzhanghao = true;
						continue;
					}
					if(o=='yishengxingming'){
						this.ruleForm.yishengxingming = obj[o];
						this.ro.yishengxingming = true;
						continue;
					}
					if(o=='zhuanye'){
						this.ruleForm.zhuanye = obj[o];
						this.ro.zhuanye = true;
						continue;
					}
					if(o=='huanzhezhanghao'){
						this.ruleForm.huanzhezhanghao = obj[o];
						this.ro.huanzhezhanghao = true;
						continue;
					}
					if(o=='huanzhexingming'){
						this.ruleForm.huanzhexingming = obj[o];
						this.ro.huanzhexingming = true;
						continue;
					}
					if(o=='huanzhedianhua'){
						this.ruleForm.huanzhedianhua = obj[o];
						this.ro.huanzhedianhua = true;
						continue;
					}
					if(o=='nianling'){
						this.ruleForm.nianling = obj[o];
						this.ro.nianling = true;
						continue;
					}
					if(o=='yibaokahao'){
						this.ruleForm.yibaokahao = obj[o];
						this.ro.yibaokahao = true;
						continue;
					}
				}
			}
			this.styleChange()
			this.$forceUpdate()
			if (uni.getStorageSync('raffleType') && uni.getStorageSync('raffleType') != null) {
				uni.removeStorageSync('raffleType')
				setTimeout(() => {
					this.onSubmitTap()
				}, 300)
			}
		},
		methods: {
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},

			// 多级联动参数


			// 日长控件选择日期时间
			quxiaoshijianConfirm(val) {
				console.log(val)
				this.ruleForm.quxiaoshijian = val.result;
				this.$forceUpdate();
			},

			// 下拉变化
			keshifenleiChange(e) {
				this.keshifenleiIndex = e.target.value
				this.ruleForm.keshifenlei = this.keshifenleiOptions[this.keshifenleiIndex]
			},

			touxiangTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(()=>{
						_this.styleChange()
					})
				});
			},

			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
				let that = this
				this.ruleForm.ispay = '未支付'
				//跨表计算判断
				var obj;
				if((!this.ruleForm.keshimingcheng)){
					this.$utils.msg(`科室名称不能为空`);
					return
				}
				if((!this.ruleForm.guahaofei)){
					this.$utils.msg(`挂号费不能为空`);
					return
				}
				if(this.ruleForm.guahaofei&&(!this.$validate.isIntNumer(this.ruleForm.guahaofei))){
					this.$utils.msg(`挂号费应输入整数`);
					return
				}
				if((!this.ruleForm.quxiaoshijian)){
					this.$utils.msg(`取消时间不能为空`);
					return
				}
				if((!this.ruleForm.quxiaoyuanyin)){
					this.$utils.msg(`取消原因不能为空`);
					return
				}
				if((!this.ruleForm.yishengxingming)){
					this.$utils.msg(`医生姓名不能为空`);
					return
				}
				//更新跨表属性
				var crossuserid;
				var crossrefid;
				var crossoptnum;
				if(this.cross){
					uni.setStorageSync('crossCleanType',true);
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
						if(!obj) {
							obj = uni.getStorageSync('crossObj');
						}
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}

							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
							   crossuserid=Number(uni.getStorageSync('appUserid'));
							   crossrefid=obj['id'];
							   crossoptnum=uni.getStorageSync('statusColumnName');
							   crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid=crossuserid;
					this.ruleForm.crossrefid=crossrefid;
					let params = {
						page: 1,
						limit:10,
						crossuserid:crossuserid,
						crossrefid:crossrefid,
					}
					let res = await this.$api.list(`quxiaoguahao`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
						uni.removeStorageSync('crossCleanType');
						return false;
					} else {
				//跨表计算
						let oet = {}
						if(this.ruleForm.id){
							await this.$api.update(`quxiaoguahao`, this.ruleForm);
						}else{
							oet = await this.$api.add(`quxiaoguahao`, this.ruleForm);
						}

						this.$utils.msgBack('提交成功');
					}
				} else {
				//跨表计算
					let oet = {}
					if(this.ruleForm.id){
						await this.$api.update(`quxiaoguahao`, this.ruleForm);
					}else{
						oet = await this.$api.add(`quxiaoguahao`, this.ruleForm);
					}

					this.$utils.msgBack('提交成功');
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				if(this.ro[str]){
					return false
				}
				this.$refs[str].show();
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
