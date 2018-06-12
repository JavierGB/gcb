//package io.swagger.configuration;
//
//import java.net.Inet4Address;
//import java.net.Inet6Address;
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//
//@Configuration
//public class ElasticsearchConfiguration {
//	private boolean ip6Enabled = true;
//	private boolean ip4Enabled = true;
//
//	@Bean
//	public Client client() throws UnknownHostException {
//		String host = "4fd603fb47cf400d9abe12ff9d0db267.us-east-1.aws.found.io";
//		int port = Integer.parseInt(System.getProperty("port", "9343"));
//
//		String hostBasedClusterName = host.split("\\.", 2)[0];
//		String clusterName = System.getProperty("cluster", hostBasedClusterName);
//
//		boolean enableSsl = Boolean.parseBoolean(System.getProperty("ssl", "true"));
//		// Note: If enabling IPv6, then you should ensure that your host and network can route it to the Cloud endpoint.
//		// (eg Docker disables IPv6 routing by default) - see also the initialization code at the top of this file.
//		ip6Enabled = Boolean.parseBoolean(System.getProperty("ip6", "true"));
//		ip4Enabled = Boolean.parseBoolean(System.getProperty("ip4", "true"));
//
//		// For testing in dev environments, similar to `curl -k` option
//		boolean insecure = Boolean.parseBoolean(System.getProperty("insecure", "false"));
//
//		
//
//		// Build the settings for our client.
//		Settings settings = Settings.builder()
//				.put("client.transport.nodes_sampler_interval", "5s")
//				.put("client.transport.sniff", false)
//				.put("transport.tcp.compress", true)
//				.put("cluster.name", clusterName)
//				.put("xpack.security.transport.ssl.enabled", enableSsl)
//				.put("request.headers.X-Found-Cluster", "${cluster.name}")
//				.put("xpack.security.user", "elastic:FfPiStKykTc1pKofOLQOpMXE")
//				.put("xpack.security.transport.ssl.verification_mode", insecure ? "none" : "full")
//				.build();
//
//		// Instantiate a TransportClient and add the cluster to the list of addresses to connect to.
//		// Only port 9343 (SSL-encrypted) is currently supported. The use of x-pack security features is required.
//		TransportClient client = new PreBuiltXPackTransportClient(settings);
//		try {
//			for (InetAddress address : InetAddress.getAllByName(host)) {
//				if ((ip6Enabled && address instanceof Inet6Address)
//						|| (ip4Enabled && address instanceof Inet4Address)) {
//					client.addTransportAddress(new InetSocketTransportAddress(address, port));
//				}
//			}
//		} catch (UnknownHostException e) {
//		}
//
//		return client;
//	}
//
//	@Bean
//	public ElasticsearchTemplate elasticsearchTemplate() throws UnknownHostException {
//		return new ElasticsearchTemplate(client());
//	}
//}