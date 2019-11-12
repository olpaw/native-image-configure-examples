import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.ImageSingletons;
import org.graalvm.nativeimage.hosted.RuntimeClassInitialization;

import java.net.URLConnection;

class ConfigureAtBuildTimeFeature implements Feature {

	public void beforeAnalysis(BeforeAnalysisAccess access) {
		try {
			ImageSingletons.add(Configuration.class, Configuration.loadFromFile());
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
	}
}

public class ConfigureAtBuildTime {
	public static void main(String[] args) throws Throwable {
		Configuration configuration = ImageSingletons.lookup(Configuration.class);
		System.out.println(configuration.handler.handle());
	}
}
