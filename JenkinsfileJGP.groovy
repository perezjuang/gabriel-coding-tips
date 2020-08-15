pipeline {
    agent any
          /* https://www.journaldev.com/33645/maven-commands-options-cheat-sheet  */
    environment {
        gitURL = 'https://perezjuang:86100252807aA*@github.com/perezjuang/gabriel-coding-tips.git'
        branchDEV = 'dev'
        branchQA = 'qa'
        branchPRD = 'master'
        projectName= 'demojgpback'
    }

    stages {
        stage('GET-CODE') {
            steps {
                echo 'GET-CODE================================================'
                catchError(buildResult: 'SUCCESS', stageResult: 'SUCCESS')
            {
                    bat  '''
                              mkdir DEV
                             '''.stripIndent().trim()
            }

                dir ('DEV') {
                    git branch: env.branchPRD, url: env.gitURL
                }
            }
        }

        stage('TEST_UNIT') {
            steps {
                echo 'TEST ============================================'
                dir ('DEV') {
                    dir (env.projectName) {
                        bat  '''
                        mvn verify
                        '''.stripIndent().trim()
                    }
                }
            }
        }

        stage('COMPILE') {
            steps {
                echo '====================================================='
                echo 'COMPILE'
                echo '====================================================='
                dir ('DEV') {
                    dir (env.projectName) {
                        bat  '''
                      mvn package
                      mvn install
                     '''.stripIndent().trim()
                    }
                }
            }
        }






        stage('GENERATE_ARTIFACTS') {
            steps {
                parallel('GENERATE_ARTIFACTS_GIT': {
            //git branch: env.branchPRD, url: env.gitURL
            dir ('DEV') {
                   dir (env.projectName) {
                        script {
                            def date = new Date()
                            println date
                             println date.format('yyyy/MM/dd_HH:mm', TimeZone.getTimeZone('IST'))
                        bat 'git config --global user.email "perezjuang@hotmail.com"'
                        bat 'git config --global user.name "perezjuang"'
                        bat 'git tag -a ' + date.format('yyyy_MM_dd_HH_mm', TimeZone.getTimeZone('IST')) + " -m 'Jenkins'"
                        bat 'git push ' + env.gitURL + ' --tags'

                         /*   def pom = new File('C:\\Program Files (x86)\\Jenkins\\workspace\\devopsTest\\DEV\\demoJGPDevSecOps\\pom.xml').getText('utf-8')
//def pom = new File('pom.xml').getText('utf-8')
def doc = new XmlParser().parseText(pom)
def version = doc.version.toString()

println(version)*/

                       // increase version number
                       /* def version = pom.version.text().toString().replace("-SNAPSHOT", "").split("\\.")
                        version[-1] = version[-1].toInteger()+1
                        println "Previoues version of pom: ${pom.version}"
                        pom.version = version.join('.')
                        println "New Version of pom: ${pom.version}"

                        bat "git tag -a ${pom.version} -m 'Jenkins'"
                        bat "git push " + env.gitURL + " --tags"
                           //================================================================
                           /*
                           println "Release Script Start -----"

def dir = new File('pom.xml')..getText('utf-8')
// copy a backup of the pom
println "A copy of the old pom is saved in pom.backup.xml"
ant.copy(file: dir, tofile: "pom.backup.xml")

def pom = new XmlSlurper().parse(dir)

// increase version number
def version = pom.version.toString().replace("-SNAPSHOT", "").split("\\.")
version[-1] = version[-1].toInteger()+1
println "Previoues version of pom: ${pom.version}"
pom.version = version.join('.')
println "New Version of pom: ${pom.version}"

// remove snapshots in properties
print "remove snapshots in properties "
pom.properties.childNodes().each{
    it.replaceBody(it.text().replace("-SNAPSHOT", ""))
}
println "OK"

// remove snapshots in dependencies
print "remove snapshots in dependencies "
pom.dependencies.dependency.each{
    it.version.replaceBody(it.version.text().replace("-SNAPSHOT", ""))
}
println "OK"

// output the pom
print "Writing new pom.xml "

def writer = dir.newWriter()
writer << XmlUtil.serialize(result)
writer.close()
println "OK"
println "Release Script End -----"

                         //==================================================================
                         */

                        }
                   }
            }
                },

                'GENERATE_ARTIFACTS_BACKUP': {
                            echo 'world'
                }

                )
            }
        }




        stage('ACEPTED_FUNCTIONAL_AUTOMATICS_TEST') {
            steps {
                parallel('RUN_CUCUMBER_SELENIUM': {

                },

                'GENERATE_METRICS': {
                            echo 'world'
                }

                )
            }
        }

        stage('DESPLOY_TEST_ENVIROMENT') {
            steps {
                parallel('DEV': {

                },

                'QA': {
                            echo 'world'
                }

                )
            }
        }
        stage('DESPLOY_MANUAL_CHECK APROBACION') {
            steps {
                parallel('CHECK_APPROVER1': {
                        input("Listo para el Despliegue?")
                },

                'CHECK_APPROVER2': {
                           input("Listo para el Despliegue?")
                }

                )
            }
        }        
        stage('DESPLOY_PRODUCTION_ENVIROMENT') {
            steps {
                parallel('NODE1_DOCKER': {

                },

                'NODE2_DOCKER': {
                            echo 'world'
                }
                'NODE3_DOCKER': {
                            echo 'world'
                }

                )
            }
        }









  /*
  sh 'git tag -a tagName -m "Your tag comment"'
sh 'git merge develop'
sh 'git commit -am "Merged develop branch to master'
sh "git push origin master"

   bat('git push https://perezjuang:86100252807aA*@github.com/perezjuang/gabriel-coding-tips.git --tags')

*//*
 bat 'git tag https://perezjuang:86100252807aA*@github.com/perezjuang/gabriel-coding-tips.git -a tagName -m "Comentario01"'
 bat 'git merge https://perezjuang:86100252807aA*@github.com/perezjuang/gabriel-coding-tips.git master'
 bat 'git commit https://perezjuang:86100252807aA*@github.com/perezjuang/gabriel-coding-tips.git  -am "Merged Master branch to master'
 bat "git push https://perezjuang:86100252807aA*@github.com/perezjuang/gabriel-coding-tips.git origin master"
*/

//}
}

   }
