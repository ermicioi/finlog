@Grab(group = 'org.codehaus.groovy.modules.http-builder', module = 'http-builder', version = '0.7.1')
import groovyx.net.http.HTTPBuilder


try {
    httpBuilder = new HTTPBuilder('http://localhost:8080')
    httpBuilder.auth.basic("root@root.com", "rootpass")
    httpBuilder.post(
            path: '/users',
            requestContentType: 'application/json',
            body: [
                    'email'   : 'user@user.com',
                    'password': 'thepass'
            ]
    )
} catch (e) {
    print "Request error with status ${e.getStatusCode()}"
}
