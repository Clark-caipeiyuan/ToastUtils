package com.wiggins.toastlibrary.DialogUtils

/**
 * FileName: DialogProtocol
 * Author: Administrator
 * Date: 2020/12/2 0002 9:59
 * Description:
 */


import android.app.Dialog
import android.content.Context;
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.Toast
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.dialog_protocol.*
import com.wiggins.toastlibrary.Model.ProtocolsRes
import com.wiggins.toastlibrary.R

/**
 * author : clark
 * date : 2020/11/28
 * description :
 */
class DialogProtol(context:Context, protocolsRes: ProtocolsRes) : Dialog(context, R.style.alertdialog) {

    var mContext: Context = context
    var iProtocolDialog: IProtocolDialog? = null
    lateinit var protocolText: TextView
    var protocolsRes: ProtocolsRes = protocolsRes
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LayoutInflater.from(mContext).inflate(R.layout.dialog_protocol, null))
        ButterKnife.bind(this)
        val divierId = mContext.resources.getIdentifier("android:id/titleDivider", null, null)
        val divider = findViewById<View>(divierId)
        divider.visibility = View.GONE
        initView()
    }

    private fun initView() {
        //新版本用户协议
        protocolText = dialog_protocol
        protocolText.setText(context.resources.getString(R.string.dialog_tips_start))
        for ((index, element) in protocolsRes.userAppAgreementDtos.withIndex()) {
            val spStr: SpannableString
            spStr = if (index == protocolsRes.userAppAgreementDtos.size - 1) {
                SpannableString(element.agreementName)
            } else {
                SpannableString(element.agreementName + "和")
            }
            val protocol = element.agreementName
            //设置超链接
            val clickSpan = NoLineClickSpan("#2184FA", protocolsRes.userAppAgreementDtos[index].h5Url, mContext)
            spStr.setSpan(clickSpan, 0, protocol.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            protocolText.append(spStr)
        }
        //添加协议文本
//        val spStr = SpannableString("《用户注册协议》和《隐私协议》")
//        val s1 = "《用户注册协议》"
//        val s2 = "《隐私协议》"
//        val clickSpan1 = NoLineClickSpan("#2184FA", Constant.BASE_URL + "app-front-end/#/common/agreementHuiminWallet", mContext) //设置超链接
//        val clickSpan2 = NoLineClickSpan("#2184FA", Constant.BASE_URL + "app-front-end/#/common/agreementHuiminWallet", mContext) //设置超链接
//        spStr.setSpan(clickSpan1, 0, s1.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
//        spStr.setSpan(clickSpan2, s1.length + 1, s1.length + 1 + s2.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
//        protocolText.append(spStr)
        protocolText.append(String.format(context.resources.getString(R.string.dialog_tips_end), "APP"))
        protocolText.setMovementMethod(LinkMovementMethod.getInstance())
        btn_cancel?.setOnClickListener { v: View? ->
            dismiss()
            //记录取消的点击操作
//            var versionCode: String = ACache.get(DaggerApplication.getIns()).getAsString("protocolVersion")
//            var jsonObject: JSONObject? = ACache.get(DaggerApplication.getIns())?.getAsJSONObject("protocol_list")
//            if (jsonObject == null) {
//                jsonObject = JSONObject()
//            }
//            jsonObject.put(versionCode, false)
//            ACache.get(DaggerApplication.getIns()).put("protocol_list", jsonObject)

        }
        cb_authorization?.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked: Boolean -> btn_ok?.isEnabled = isChecked }
        btn_ok?.setOnClickListener { v: View? ->
            if (iProtocolDialog != null) {
                if (cb_authorization.isChecked) {
                    iProtocolDialog?.onclick()
                    dismiss()
                } else {
                    Toast.makeText(mContext, "请勾选协议", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    //提供接口
    fun setiProtocolDialog(iProtocolDialog: IProtocolDialog?) {
        if (iProtocolDialog != null) {
            this.iProtocolDialog = iProtocolDialog
        }
    }

    interface IProtocolDialog {
        fun onclick()
    }

    //去除默认的clickSpan的下划线
    internal class NoLineClickSpan(var color: String, mUrl: String, context: Context) : ClickableSpan() {
        var context: Context = context;
        var url: String = mUrl;
        override fun updateDrawState(ds: TextPaint) {
            //设置字体颜色
            ds.color = (Color.parseColor(color))
            ds.isUnderlineText = false //去掉下划线
        }

        override fun onClick(widget: View) {
            //点击超链接时调用
            Log.d("MainActiviy", "您点击了协议")
            val bundle = Bundle()
            bundle.putString("url", url)
           // JumpUtils.jumptoNatvie(context, "webView", 0, bundle)
        }
    }

}