package com.wiggins.toastlibrary.Model
/*
 *userAppAgreementDtos : [{"agreementId":1,"agreementName":"<用户同意条款1>","versionId":22,"versionName":"v22","h5Url":null},{"agreementId":2,"agreementName":"<用户同意条款2>","versionId":44,"versionName":"v44","h5Url":null},{"agreementId":3,"agreementName":"<用户同意条款3>","versionId":99,"versionName":"v99","h5Url":null}]
 * code : 000000
 * message : 操作成功
 */
/**
 * @param code   返回码
 * @param message 返回信息
 * @param userAppAgreementDtos 协议数组
 *
 */
data class ProtocolsRes(
    val code: String,
    val message: String,
    val userAppAgreementDtos: List<UserAppAgreementDto>
)

data class UserAppAgreementDto(
    val agreementId: Int,
    val agreementName: String,
    val h5Url: String,
    val versionId: Int,
    val versionName: String
)