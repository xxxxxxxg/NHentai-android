package moe.feng.nhentai.util

import moe.feng.nhentai.api.ApiConstants
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.util.concurrent.TimeUnit

object HttpUtils {

	private val client: OkHttpClient by lazy {
		OkHttpClient.Builder()
				.connectTimeout(10, TimeUnit.SECONDS)
				.readTimeout(10, TimeUnit.SECONDS)
				.build()
	}

	private val TAG = HttpUtils::class.java.simpleName

	private const val HEADER_USER_AGENT = "User-Agent"

	@Throws(IOException::class)
	fun requestUrl(url: String): Response = Request.Builder().url(url)
			.addHeader(HEADER_USER_AGENT, ApiConstants.NHBOOKS_UA)
			.build()
			.run(client::newCall)
			.execute()

}