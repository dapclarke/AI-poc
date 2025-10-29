
param location string = 'UK South'
param appName string = 'dunc-rest-service-dctesttmp'
param appServicePlanName string = 'DuncASP'
param javaVersion string = 'Java 17'

resource appServicePlan 'Microsoft.Web/serverfarms@2022-03-01' existing = {
  name: appServicePlanName
}

resource webApp 'Microsoft.Web/sites@2022-03-01' = {
  name: appName
  location: location
  kind: 'app,linux'
  properties: {
    serverFarmId: appServicePlan.id
    siteConfig: {
      linuxFxVersion: 'JAVA|17-java17'
    }
  }
}
