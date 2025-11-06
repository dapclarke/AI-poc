
@description('The name of the web app to create')
param appName string

@description('Location for all resources')
param location string = resourceGroup().location

@description('Name of the App Service Plan')
param appServicePlanName string = 'DuncCICD-asp'
param sku string = 'P0v3' // Tier of the App Service plan - Note: Deployment slots require Standard or higher
//param javaVersion string = 'Java 17'

// Slot configuration
param enableSlots bool = true  // Enable/disable deployment slots
param slotNames array = [
  'main'
  'development'
]

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
      // Enable slot settings
      numberOfWorkers: 1
    }
  }
}

// Production slot is the default slot (already created with the web app above)

// Deploy slots using array
resource slots 'Microsoft.Web/sites/slots@2022-03-01' = [for slotName in slotNames: if(enableSlots) {
  parent: webApp
  name: slotName
  location: location
  kind: 'app,linux'
  properties: {
    serverFarmId: appServicePlan.id
    siteConfig: {
      linuxFxVersion: 'JAVA|17-java17'
      appSettings: [
        {
          name: 'SLOT_NAME'
          value: slotName
        }
      ]
    }
  }
}]
