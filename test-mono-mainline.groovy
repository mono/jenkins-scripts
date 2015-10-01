ws {
parallel debian-amd64: {
    node('debian-amd64') {
        load 'test-mono-mainline-MATRIX.groovy'
    }
}, debian-i386: {
    node('debian-i386') {
        load 'test-mono-mainline-MATRIX.groovy'
    }
}, debian-armel: {
    node('debian-armel') {
        load 'test-mono-mainline-MATRIX.groovy'
    }
}, debian-armhf: {
    node('debian-armhf') {
        load 'test-mono-mainline-MATRIX.groovy'
    }
}, osx-i386: {
    node('osx-i386') {
        load 'test-mono-mainline-MATRIX.groovy'
    }
}, 
failFast: false
}
