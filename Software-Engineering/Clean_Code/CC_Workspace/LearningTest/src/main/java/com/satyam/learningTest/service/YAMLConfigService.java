package com.satyam.learningTest.service;

import com.satyam.learningTest.pojo.Config;
import com.satyam.learningTest.util.ConfigLoadException;
import com.satyam.learningTest.util.YamlUnMarshaller;

public class YAMLConfigService implements ConfigService{

	private Config config;

	public YAMLConfigService(String configPath) throws ConfigLoadException{
		try {
			YamlUnMarshaller yaml = new YamlUnMarshaller(configPath);
			this.config = yaml.load();
		}
		catch(ConfigLoadException e) {
			throw e;
		}
	}

	@Override
	public String getServerIP() {
		return config.getServer().getIP();
	}

	@Override
	public int getServerPort() {
		return config.getServer().getPort();
	}

	@Override
	public String getServerName() {
		return config.getServer().getName();
	}

	@Override
	public String getDBHost() {
		return config.getDatabase().getHost();
	}

	@Override
	public int getDBPort() {
		return config.getDatabase().getPort();
	}

}
