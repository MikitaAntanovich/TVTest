package my.tv.tvt

object Canals {
    val url_bt_1_hd =
        "https://ngtrk.dc.beltelecom.by/ngtrk/smil:belarus1.smil/playlist.m3u8?wmsAuthSign=c2VydmVyX3RpbWU9MTAvMTYvMjAyMyAxMDoyMjozNCBQTSZoYXNoX3ZhbHVlPWF5Q2VOYTdRS2xCMHZETVVMRll1dFE9PSZ2YWxpZG1pbnV0ZXM9MTIw"
    val url_bt_2_hd =
        "https://ngtrk.dc.beltelecom.by/ngtrk/smil:belarus2.smil/playlist.m3u8?wmsAuthSign=c2VydmVyX3RpbWU9MTAvMTcvMjAyMyAyOjIxOjM2IFBNJmhhc2hfdmFsdWU9eWt2L2Q4RmJ1TlRxanA0TExIcXNoUT09JnZhbGlkbWludXRlcz0xMjA="
    val url_multilandiya =
        "https://okkotv-live.cdnvideo.ru/channel/Multilandia_HD/1080p.m3u8?wmsAuthSign=c2VydmVyX3RpbWU9MTEvMS8yMDIzIDQ6MDg6MTUgUE0maGFzaF92YWx1ZT05ckRTcC9SeVBlREI0RnRYeHlQOE5BPT0mdmFsaWRtaW51dGVzPTI1"
    val url_zhara =
        "http://hls-zhara.cdnvideo.ru/zhara/zhara/chunklist.m3u8?hls_proxy_host=e10fdea521d040351035e14ac2c3ed93"
    val url_ont =
        "https://tbs01-edge11.itdc.ge/ort/tracks-v1a1/mono.m3u8"
    val url_detskiy_mir = "https://tbs01-edge11.itdc.ge/detskymir/tracks-v1a1/mono.m3u8"
    val url_backus = "https://playlist.wasd.tv/live/1722235/tracks-v1a1/mono.m3u8"
    val url_backus_dark = "https://playlist.wasd.tv/live/1722236/tracks-v1a1/mono.m3u8"
    val url_smotrim_rus =
        "https://live-vgtrksmotrim.cdnvideo.ru/vgtrksmotrim/smotrim-live-01.smil/tracks-v3a1/mono.m3u8"

    val allCanals = arrayOf(
        url_multilandiya,
        url_detskiy_mir,
        url_backus_dark,
        url_backus,
        url_zhara,
        url_ont,
        url_bt_1_hd,
        url_bt_2_hd,
        url_smotrim_rus
    )
    val maxCanal = allCanals.size
}