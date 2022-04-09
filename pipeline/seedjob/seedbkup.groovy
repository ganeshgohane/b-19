pipelineJob('') {

  description('')

  displayName('scriptedpipelines_converted')

  configure { flowdefinition ->

    flowdefinition / 'properties' << 'com.dabsquared.gitlabjenkins.connection.GitLabConnectionProperty'(plugin:'gitlab-plugin@1.5.29') {

      'gitLabConnection'()

      'jobCredentialId'()

      'useAlternativeCredential'(false)

    }

    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps@2686.v7c37e0578401') {

      'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {

        'configVersion'(2)

        'userRemoteConfigs' {

          'hudson.plugins.git.UserRemoteConfig' {

            'url'('https://github.com/ganeshgohane/b-19.git')

            'credentialsId'('ide')

          }

        }

        'branches' {

          'hudson.plugins.git.BranchSpec' {

            'name'('*/master')

          }

        }

        'doGenerateSubmoduleConfigurations'(false)

        'submoduleCfg'(class:'empty-list')

        'extensions'()

      }

      'scriptPath'('pipeline/scripted.groovy')

      'lightweight'(true)

    }

  }

}
