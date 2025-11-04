
param location string = resourceGroup().location // Location for all resources
param appName string = 'dunc-rest-service-dctesttmp'
param appServicePlanName string = 'DuncCICD-asp'
param sku string = 'B1' // Tier of the App Service plan
//param javaVersion string = 'Java 17'

resource appServicePlan 'Microsoft.Web/serverfarms@2022-03-01' = {
  name: appServicePlanName
  location: location
  properties: {
    reserved: true
  }
  sku: {
    name: sku
  }
  kind: 'linux'  
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
