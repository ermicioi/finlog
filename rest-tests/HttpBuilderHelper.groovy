import groovyx.net.http.HTTPBuilder

import java.util.function.Consumer

class HttpBuilderHelper {

    private static final hostname = 'http://localhost:8080'
    private static final username = 'root@root.com'
    private static final password = 'rootpass'

    static HTTPBuilder getBuilder() {
        final HTTPBuilder httpBuilder = new HTTPBuilder(hostname)
        httpBuilder.auth.basic(username, password)

        return httpBuilder
    }

    static void execute(Consumer<HTTPBuilder> callback) {
        try {
            callback.accept(getBuilder())
        } catch (e) {
            print "Error executing http request: ${e}"
        }
    }

}