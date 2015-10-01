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
    stage '*** verify'
    timeout(15) {
        try {
            sh 'make -C runtime mcs-compileall'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** profiler'
    timeout(5) {
        try {
            sh 'make -C mono/profiler -k check'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** compiler-4.5'
    timeout(30) {
        try {
            sh 'make -C mcs/tests run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** compiler-errors-4.5'
    timeout(30) {
        try {
            sh 'make -C mcs/errors run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System-4.5'
    timeout(10) {
        try {
            sh 'make -C mcs/class/System run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.XML-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.XML run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** Mono.Security-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/Mono.Security run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Security-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Security run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Drawing-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Drawing run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** Windows.Forms-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/Managed.Windows.Forms run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Data-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Data run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Data.OracleClient-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Data.OracleClient run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Design-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Design run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** Mono.Posix-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/Mono.Posix run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Web-4.5'
    timeout(30) {
        try {
            sh 'make -C mcs/class/System.Web run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Web.Services-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Web.Services run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Runtime.SFS-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Runtime.Serialization.Formatters.Soap run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Runtime.Remoting-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Runtime.Remoting run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** Cscompmgd-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/Cscompmgd run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** Commons.Xml.Relaxng-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/Commons.Xml.Relaxng run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.ServiceProcess-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.ServiceProcess run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** I18N.CJK-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/I18N/CJK run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** I18N.West-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/I18N/West run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** I18N.MidEast-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/I18N/MidEast run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.DirectoryServices-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.DirectoryServices run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** Microsoft.Build.Engine-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/Microsoft.Build.Engine run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** Microsoft.Build.Framework-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/Microsoft.Build.Framework run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** Microsoft.Build.Tasks-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/Microsoft.Build.Tasks run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** Microsoft.Build.Utilities-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/Microsoft.Build.Utilities run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** Mono.C5-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/Mono.C5 run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Configuration-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Configuration run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Transactions-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Transactions run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Web.Extensions-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Web.Extensions run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Core-4.5'
    timeout(15) {
        try {
            sh 'make -C mcs/class/System.Core run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** symbolicate'
    timeout(60) {
        try {
            sh 'make -C mcs/tools/mono-symbolicate check'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Xml.Linq-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Xml.Linq run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Data.DSE-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Data.DataSetExtensions run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Web.Abstractions-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Web.Abstractions run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Web.Routing-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Web.Routing run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Runtime.Serialization-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Runtime.Serialization run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.IdentityModel-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.IdentityModel run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.ServiceModel-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.ServiceModel run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.ServiceModel.Web-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.ServiceModel.Web run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Web.Extensions-standalone'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Web.Extensions run-standalone-test'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.ComponentModel.DataAnnotations-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.ComponentModel.DataAnnotations run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** Mono.CodeContracts-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/Mono.CodeContracts run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Runtime.Caching-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Runtime.Caching run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Data.Services-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Data.Services run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Web.DynamicData-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Web.DynamicData run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** Mono.CSharp-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/Mono.CSharp run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** WindowsBase-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/WindowsBase run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Numerics-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Numerics run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Runtime.DurableInstancing-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Runtime.DurableInstancing run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.ServiceModel.Discovery-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.ServiceModel.Discovery run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Xaml-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Xaml run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Net.Http-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Net.Http run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Json-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Json run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** System.Threading.Tasks.Dataflow-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/System.Threading.Tasks.Dataflow run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** Mono.Debugger.Soft-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/Mono.Debugger.Soft run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** Microsoft.Build-4.5'
    timeout(5) {
        try {
            sh 'make -C mcs/class/Microsoft.Build run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
    stage '*** monodoc'
    timeout(10) {
        try {
            sh 'make -C mcs/tools/mdoc run-test TEST_HARNESS_FLAGS=-labels PROFILE=net_4_x'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    stage '*** Microsoft.Build-12'
    timeout(60) {
        try {
            sh 'make -C mcs/class/Microsoft.Build run-test TEST_HARNESS_FLAGS=-labels PROFILE=xbuild_12'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    stage '*** Microsoft.Build.Engine-12'
    timeout(60) {
        try {
            sh 'make -C mcs/class/Microsoft.Build.Engine run-test TEST_HARNESS_FLAGS=-labels PROFILE=xbuild_12'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    stage '*** Microsoft.Build.Framework-12'
    timeout(60) {
        try {
            sh 'make -C mcs/class/Microsoft.Build.Framework run-test TEST_HARNESS_FLAGS=-labels PROFILE=xbuild_12'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    stage '*** Microsoft.Build.Tasks-12'
    timeout(60) {
        try {
            sh 'make -C mcs/class/Microsoft.Build.Tasks run-test TEST_HARNESS_FLAGS=-labels PROFILE=xbuild_12'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    stage '*** Microsoft.Build.Utilities-12'
    timeout(60) {
        try {
            sh 'make -C mcs/class/Microsoft.Build.Utilities run-test TEST_HARNESS_FLAGS=-labels PROFILE=xbuild_12'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    stage '*** Microsoft.Build-14'
    timeout(60) {
        try {
            sh 'make -C mcs/class/Microsoft.Build run-test TEST_HARNESS_FLAGS=-labels PROFILE=xbuild_14'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    stage '*** Microsoft.Build.Engine-14'
    timeout(60) {
        try {
            sh 'make -C mcs/class/Microsoft.Build.Engine run-test TEST_HARNESS_FLAGS=-labels PROFILE=xbuild_14'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    stage '*** Microsoft.Build.Framework-14'
    timeout(60) {
        try {
            sh 'make -C mcs/class/Microsoft.Build.Framework run-test TEST_HARNESS_FLAGS=-labels PROFILE=xbuild_14'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    stage '*** Microsoft.Build.Tasks-14'
    timeout(60) {
        try {
            sh 'make -C mcs/class/Microsoft.Build.Tasks run-test TEST_HARNESS_FLAGS=-labels PROFILE=xbuild_14'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    stage '*** Microsoft.Build.Utilities-14'
    timeout(60) {
        try {
            sh 'make -C mcs/class/Microsoft.Build.Utilities run-test TEST_HARNESS_FLAGS=-labels PROFILE=xbuild_14'
        } catch(e) {
            currentBuild.result = 'UNSTABLE'
        }
    }
