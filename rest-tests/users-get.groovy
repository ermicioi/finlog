@Grab(group = 'org.codehaus.groovy.modules.http-builder', module = 'http-builder', version = '0.7.1')
import static HttpBuilderHelper.execute

execute(httpBuilder -> {
    httpBuilder.get(path: '/users', query: [
            'email': 'root@root.com'
    ]) { response, data ->
        print data
    }
})