<template>
<view class="content">
	<view class="box" :style='{"width":"100%","padding":"0","alignItems":"center","background":"url(http://codegen.caihongy.cn/20241221/0a6a48ef0d2a463a951920312c2aea25.png) top center/100% 55% no-repeat","display":"flex","height":"100%"}'>
		<view :style='{"padding":"30rpx 30rpx 0","boxShadow":"0px 8rpx 8rpx 0px rgba(0, 0, 0, 0.25)","margin":"0 auto","flexWrap":"wrap","background":"#fff","display":"flex","width":"80%","position":"relative","height":"auto"}'>
			<image :style='{"width":"160rpx","margin":"0 auto 24rpx auto","borderRadius":"8rpx","display":"none","height":"160rpx"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" mode="aspectFill"></image>
			<view :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"2"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">医保卡号：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","width":"calc(100% - 130rpx)","fontSize":"28rpx","height":"70rpx"}' v-model="ruleForm.yibaokahao" type="text" class="uni-input" name="" placeholder="医保卡号" />
			</view>
			<view :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"2"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">患者账号：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","width":"calc(100% - 130rpx)","fontSize":"28rpx","height":"70rpx"}'  v-model="ruleForm.huanzhezhanghao"  type="text"  class="uni-input" name="" placeholder="患者账号" />
			</view>
			<view :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"2"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">密码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","width":"calc(100% - 130rpx)","fontSize":"28rpx","height":"70rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"2"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">确认密码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","width":"calc(100% - 130rpx)","fontSize":"28rpx","height":"70rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"2"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">患者姓名：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","width":"calc(100% - 130rpx)","fontSize":"28rpx","height":"70rpx"}'  v-model="ruleForm.huanzhexingming"  type="text"  class="uni-input" name="" placeholder="患者姓名" />
			</view>
            <view :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"2"}' v-if="tableName=='huanzhe'" @tap="huanzhetouxiangTap" class="">
				<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">头像：</view>
				<image :style='{"width":"80rpx","borderRadius":"16rpx","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"80rpx","borderRadius":"16rpx","display":"block","height":"80rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
            <view :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"2"}' v-if="tableName=='huanzhe'" class="">
				<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">性别：</view>
				<picker :style='{"width":"100%","margin":"0","alignItems":"center","flex":"1","display":"flex","height":"auto"}' v-if="tableName=='huanzhe'"  @change="huanzhexingbieChange" :value="huanzhexingbieIndex" :range="huanzhexingbieOptions">
					<view>
						<view :style='{"padding":"0 20rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#000","flex":"1"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
			<view :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"2"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">患者电话：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","width":"calc(100% - 130rpx)","fontSize":"28rpx","height":"70rpx"}'  v-model="ruleForm.huanzhedianhua"  type="text"  class="uni-input" name="" placeholder="患者电话" />
			</view>
			<view :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"2"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">年龄：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","width":"calc(100% - 130rpx)","fontSize":"28rpx","height":"70rpx"}'  v-model="ruleForm.nianling"  type="text"  class="uni-input" name="" placeholder="年龄" />
			</view>
			<view :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"2"}' v-if="tableName=='yisheng'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">医生账号：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","width":"calc(100% - 130rpx)","fontSize":"28rpx","height":"70rpx"}'  v-model="ruleForm.yishengzhanghao"  type="text"  class="uni-input" name="" placeholder="医生账号" />
			</view>
			<view :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"2"}' v-if="tableName=='yisheng'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">密码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","width":"calc(100% - 130rpx)","fontSize":"28rpx","height":"70rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"2"}' v-if="tableName=='yisheng'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">确认密码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","width":"calc(100% - 130rpx)","fontSize":"28rpx","height":"70rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"2"}' v-if="tableName=='yisheng'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">医生姓名：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","width":"calc(100% - 130rpx)","fontSize":"28rpx","height":"70rpx"}'  v-model="ruleForm.yishengxingming"  type="text"  class="uni-input" name="" placeholder="医生姓名" />
			</view>
            <view :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"2"}' v-if="tableName=='yisheng'" @tap="yishengtouxiangTap" class="">
				<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">头像：</view>
				<image :style='{"width":"80rpx","borderRadius":"16rpx","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"80rpx","borderRadius":"16rpx","display":"block","height":"80rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<view :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"2"}' v-if="tableName=='yisheng'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">联系电话：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","width":"calc(100% - 130rpx)","fontSize":"28rpx","height":"70rpx"}'  v-model="ruleForm.lianxidianhua"  type="text"  class="uni-input" name="" placeholder="联系电话" />
			</view>
			<view :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"2"}' v-if="tableName=='yisheng'" class="uni-form-item uni-column">
				<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">专业：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgb(255, 255, 255)","width":"calc(100% - 130rpx)","fontSize":"28rpx","height":"70rpx"}'  v-model="ruleForm.zhuanye"  type="text"  class="uni-input" name="" placeholder="专业" />
			</view>
            <view :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"2"}' v-if="tableName=='yisheng'" class="">
				<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">性别：</view>
				<picker :style='{"width":"100%","margin":"0","alignItems":"center","flex":"1","display":"flex","height":"auto"}' v-if="tableName=='yisheng'"  @change="yishengxingbieChange" :value="yishengxingbieIndex" :range="yishengxingbieOptions">
					<view>
						<view :style='{"padding":"0 20rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#000","flex":"1"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
            <view :style='{"boxShadow":"0px 8rpx 8rpx 0px rgb(234, 236, 255)","margin":"0 auto 24rpx","alignItems":"center","display":"flex","width":"95%","height":"auto","order":"2"}' v-if="tableName=='yisheng'" @tap="yishengzigezhengTap" class="">
				<view :style='{"width":"140rpx","padding":"10rpx","lineHeight":"70rpx","fontSize":"24rpx","color":"#000"}' class="label">资格证：</view>
				<image :style='{"width":"80rpx","borderRadius":"16rpx","display":"block","height":"80rpx"}' v-if="ruleForm.zigezheng" class="avator" :src="baseUrl+ruleForm.zigezheng" mode=""></image>
                <image :style='{"width":"80rpx","borderRadius":"16rpx","display":"block","height":"80rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<button :style='{"border":"0","padding":"0px","margin":"0 auto -40rpx","color":"#000","borderRadius":"8rpx","background":"linear-gradient(135.00deg, rgb(228, 173, 215) 0%,rgb(188, 255, 253) 100%)","width":"60%","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"bold","height":"80rpx","order":"6"}' class="btn-submit" @tap="register" type="primary">注册</button>
			
			<view class="idea1" :style='{"color":"#000","textAlign":"center","background":"none","display":"block","width":"100%","fontSize":"30rpx","fontWeight":"bold","height":"80rpx","order":"1"}'>注册</view>
			<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
			<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
                huanzhexingbieOptions: [],
                huanzhexingbieIndex: 0,
                yishengxingbieOptions: [],
                yishengxingbieIndex: 0,
				ruleForm: {
                yibaokahao: this.getUUID(),
                huanzhezhanghao: '',
                mima: '',
                huanzhexingming: '',
                touxiang: '',
                xingbie: '',
                huanzhedianhua: '',
                nianling: '',
                shhf: '',
                yishengzhanghao: '',
                mima: '',
                yishengxingming: '',
                touxiang: '',
                lianxidianhua: '',
                zhuanye: '',
                xingbie: '',
                zigezheng: '',
                shhf: '',
				},
				tableName:""
			}
		},
        components: {
            multipleSelect
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

                        // 自定义下拉框值
			if(this.tableName=='huanzhe'){
                this.huanzhexingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.huanzhexingbieOptions[0]
			}
                        // 自定义下拉框值
			if(this.tableName=='yisheng'){
                this.yishengxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.yishengxingbieOptions[0]
			}
			
			this.styleChange()
		},
		methods: {

            huanzhetouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
                });
            },
            // 下拉变化
            huanzhexingbieChange(e) {
                    this.huanzhexingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.huanzhexingbieOptions[this.huanzhexingbieIndex]
            },
            yishengtouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
                });
            },
            // 下拉变化
            yishengxingbieChange(e) {
                    this.yishengxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.yishengxingbieOptions[this.yishengxingbieIndex]
            },
            yishengzigezhengTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.zigezheng = 'upload/' + res.file;
					_this.$forceUpdate();
                });
            },

            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				
				if((!this.ruleForm.huanzhezhanghao) && `huanzhe` == this.tableName){
					this.$utils.msg(`患者账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `huanzhe` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`huanzhe` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if((!this.ruleForm.huanzhexingming) && `huanzhe` == this.tableName){
					this.$utils.msg(`患者姓名不能为空`);
					return
				}
				if((!this.ruleForm.touxiang) && `huanzhe` == this.tableName){
					this.$utils.msg(`头像不能为空`);
					return
				}
				if(`huanzhe` == this.tableName && this.ruleForm.huanzhedianhua&&(!this.$validate.isMobile(this.ruleForm.huanzhedianhua))){
					this.$utils.msg(`患者电话应输入手机格式`);
					return
				}
				if(`huanzhe` == this.tableName && this.ruleForm.nianling&&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
					this.$utils.msg(`年龄应输入整数`);
					return
				}
				if((!this.ruleForm.yishengzhanghao) && `yisheng` == this.tableName){
					this.$utils.msg(`医生账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `yisheng` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`yisheng` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if((!this.ruleForm.yishengxingming) && `yisheng` == this.tableName){
					this.$utils.msg(`医生姓名不能为空`);
					return
				}
				if((!this.ruleForm.touxiang) && `yisheng` == this.tableName){
					this.$utils.msg(`头像不能为空`);
					return
				}
				if(`yisheng` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
					this.$utils.msg(`联系电话应输入手机格式`);
					return
				}
				if((!this.ruleForm.zigezheng) && `yisheng` == this.tableName){
					this.$utils.msg(`资格证不能为空`);
					return
				}
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
