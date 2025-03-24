package qa.task.factories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static ScenarioContext instance;
    private final Map<String, Object> context;
    final Logger logger = LoggerFactory.getLogger(ScenarioContext.class);

    public ScenarioContext() {
        context = new HashMap<>();
    }

    public static ScenarioContext getInstance() {
        if (instance == null) {
            instance = new ScenarioContext();
        }
        return instance;
    }

    public void setContext(String key, Object value) {
        context.put(key, value);
    }

    public Object getContext(String key) {
        if (context.containsKey(key)) {
            return context.get(key);
        } else {
            logger.atWarn().setMessage("Key '{}' not found in context").addArgument(key).log();
            return null;
        }
    }
}
