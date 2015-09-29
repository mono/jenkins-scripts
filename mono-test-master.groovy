node {
    stage '*** checkout'
    git 'https://github.com/mono/mono.git'
    stage '*** configure'
    timeout(60) {
        sh './autogen.sh'
    }
    stage '*** make'
    timeout(300) {
        sh 'make'
    }
    stage '*** mini'
    timeout(5) {
        try {
            sh 'make -C mono/mini -k check'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** runtime'
    timeout(120) {
        try {
            sh 'make  -C mono/tests -k test-wrench V=1 CI=1'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** corlib-4.5'
    timeout(30) {
        try {
            sh 'make -C mcs/class/corlib run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
}
