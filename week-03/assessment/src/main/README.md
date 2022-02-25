[9:48] David Smelser






        solar_plan.md
      
      
        Markdown (GitHub)
      
    
    
    
      # SolarFarmPlan
## High-levelRequirements
User is a solar farm administrator.
- Addasolarpaneltothefarm.
- Updateasolarpanel.
- Removeasolarpanel.
- Displayallsolarpanelsinasection.
## SolarPanels
### Data
- **Section**:namethatidentifieswherethepanelisinstalled.
- **Row**:therownumberinthesectionwherethepanelisinstalled.
- **Column**:thecolumnnumberinthesectionwherethepanelisinstalled.
- **YearInstalled**
- **Material**:multicrystallinesilicon,monocrystallinesilicon,amorphoussilicon,cadmiumtelluride,orcopperindiumgalliumselenide.
- **IsTracking**:determinesifthepanelisinstalledwithsun-trackinghardware.
  Material must be a Java enum.
### Validation
- **Section**isrequiredandcannotbeblank.
- **Row**isapositivenumberlessthanorequalto250.
- **Column**isapositivenumberlessthanorequalto250.
- **YearInstalled**mustbeinthepast.
- **Material**isrequiredandcanonlybeoneofthefivematerialslisted.
- **IsTracking**isrequired.
- Thecombinedvaluesof**Section**,**Row**,and**Column**maynotbeduplicated.
## TechnicalRequirements
- Threelayerarchitecture
- Datastoredinadelimitedfile.
- Repositoriesshouldthrowacustomexception,neverfile-specificexceptions.
- Repositoryandserviceclassesmustbefullytestedwithbothnegativeandpositivecases.Donotuseyour"production"datafiletotestyourrepository.
- SolarpanelmaterialshouldbeaJavaenumwithfivevalues.
## Package/ClassOverview
```
src
├───main
│   └───java
│       └───learn
│           └───solar
│               │   App.java                      -- app entry point
│               │
│               ├───data
│               │       DataException.java        -- data layer custom exception
│               │       PanelFileRepository.java  -- concrete repository
│               │       PanelRepository.java      -- repository interface
│               │
│               ├───domain
│               │       PanelResult.java          -- domain result for handling success/failure
│               │       PanelService.java         -- panel validation/rules
│               │
│               ├───models
│               │       Material.java             -- enum representing the 5 materials
│               │       Panel.java                -- solar panel model
│               │
│               └───ui
│                       Controller.java           -- UI controller
│                       View.java                 -- all console input/output
│
└───test
    └───java
        └───learn
            └───solar
                ├───data
                │       PanelFileRepositoryTest.java    -- PanelFileRepository tests
                │       PanelRepositoryTestDouble.java  -- helps tests the service, implements PanelRepository
                │
                └───domain
                        PanelServiceTest.java           -- PanelService tests
```
## ClassDetails
### App
- `publicstaticvoidmain(String[])`--instantiateallrequiredclasseswithvalidarguments,dependencyinjection.runcontroller
### data.DataException
Custom data layer exception.
- `publicDataException(String,Throwable)`--constructor,Throwableargistherootcauseexception
### data.PanelFileRepository
- `privateStringfilePath`
- `publicList<Panel>findBySection(String)`--findsallPanelsinasection,usestheprivate`findAll`method
- `publicPaneladd(Panel)`--createaPanel
- `publicbooleanupdate(Panel)`--updateaPanel
- `publicbooleandeleteById(int)`--deleteaPanelbyitsid
- `privateList<Panel>findAll()`--findsallPanelsinthedatasource(file),doesnotneedtobepublic
- `privateStringserialize(Panel)`--convertaPanelintoaString(aline)inthefile
- `privatePaneldeserialize(String)`--convertaStringintoaPanel
### data.PanelRepository(interface)
Contract for PanelFileRepository and PanelRepositoryTestDouble.
- `List<Panel>findBySection(String)`
- `Paneladd(Panel)`
- `booleanupdate(Panel)`
- `booleandeleteById(int)`
### domain.PanelResult
- `privateArrayList<String>messages`--errormessages
- `privatePanelpanel`--anoptionalPanel
- `publicbooleanisSuccess()`--calculatedgetter,trueifnoerrormessages
- `publicList<String>getMessages()`--messagesgetter,createanewlist
- `publicPanelgetPanel()`--Panelgetter
- `publicvoidsetPanel(Panel)`--Panelsetter
- `publicvoidaddMessage(String)`--addsanerrormessagetomessages
### domain.PanelService
-  `privatePanelRepositoryrepository`--requireddatadependency
-  `publicPanelService(PanelRepository)`--constructor
-  `publicList<Panel>findBySection(String)`--pass-throughtorepository
-  `publicPanelResultadd(Panel)`--validate,thenaddviarepository
-  `publicPanelResultupdate(Panel)`--validate,thenupdateviarepository
-  `publicPanelResultdeleteById(int)`--pass-throughtorepository
-  `privatePanelResultvalidate(Panel)`--general-purposevalidationroutine
### models.Material
An enum with five values: multicrystalline silicon, monocrystalline silicon, amorphous silicon, cadmium telluride, copper indium gallium selenide. Can use industry abbreviations or full names.
### models.Panel
- `privateintid`
- `privateStringsection`
- `privateintrow`
- `privateintcolumn`
- `privateintinstallationYear`
- `privateMaterialmaterial`
- `privatebooleantracking`
- Fullgettersandsetters
- override`equals`and`hashCode`
### ui.Controller
- `privateViewview`--requiredViewdependency
- `privatePanelServiceservice`--requiredservicedependency
- `publicController(View,PanelService)`--constructorwithdependencies
- `publicvoidrun()`--kicksoffthewholeapp,menuloop
- `privatevoidviewBySection()`--coordinatesbetweenserviceandviewtodisplaypanelsinasection
- `privatevoidaddPanel()`--coordinatesbetweenserviceandviewtoaddanewpanel
- `privatevoidupdatePanel()`--coordinatesbetweenserviceandviewtoupdateapanel
- `privatevoiddeletePanel()`--coordinatesbetweenserviceandviewtodeleteapanel
### ui.View
- `privateScannerconsole`--aScannertobeusedacrossallmethods
- `publicintchooseOptionFromMenu()`--displaythemainmenuandselectanoption,usedtoController.run()
- `publicvoidprintHeader(String)`--displaytexttotheconsolewithemphasis
- `publicvoidprintResult(PanelResult)`--displayaPanelResultwitheithersuccessorfailurew/messagesincluded
- `publicvoidprintPanels(StringsectionName,List<Panel>)`--displaypanelsinasectionwiththesection'sname
- `publicPanelchoosePanel(StringsectionName,List<Panel>)`--chooseapanelfromalistofoptions(usefulforupdateanddelete)
- `publicPanelmakePanel()`--makeapanelfromscratch,usedinController.addPanel
- `publicPanelupdate(Panel)`--acceptandexistingPanel,updateit,andreturnit,usedinController.updatePanel
- `publicStringreadSection()`--readsasectionname,usedinController:viewBySection,updatePanel(mustsearchfirst),anddeletePanel
- `privateStringreadString(String)`--general-purposeconsolemethodforreadingastring
- `privateStringreadRequiredString(String)`--general-purposeconsolemethodforreadingarequiredstring
- `privateintreadInt(String)`--general-purposeconsolemethodforreadinganinteger
- `privateintreadInt(String,intmin,intmax)`--general-purposeconsolemethodforreadinganintegerwithaminandmax
- `privateMaterialreadMaterial()`--domain-specificconsolemethodforchoosingaMaterial
## Steps
1. CreateaMavenproject.
2. AddjUnit5,Jupiter,asaMavendependencyandrefreshMaven
3. Createpackages.
4. Createthe`Panel`model.
5. Createthe`Material`enum.
6. Createthedatalayer'scustom`DataException`
7. Createthe`PanelFileRepository`class.
   AllmethodsshouldcatchIOExceptionsandthrow`DataException`.
    - addthefilePathfieldandcreateaconstructortoinitializethefield
    - generatetestsfor`PanelFileRepository`,shouldbelocatedin`src/test/java/learn/solar/data/PanelFileRepositoryTest`
    - createa`data`directoryintheprojectroot.addtest,seed,andproductiondatafiles
    - implement`findAll`,`serialize`,and`deserialize`.theseareallprivatemethod.maybeusefultomake`findAll`publictemporarilyandtestitquick.
    - implement`findBySection`,ituses`findAll`.testitnaively(noknown-good-statefornow)
    - implement`add`
    - improvetestsbyestablishingknown-good-statewith`@BeforeAll`
    - test`add`
    - implement`update`
    - test`update`
    - implement`deleteById`
    - test`deleteById`
8. Extractthe`PanelRepository`interface(IntelliJ:Refactor->ExtractInterface)from`PanelFileRepository`.
9. Create`PanelResult`.
10. Create`PanelService`.
    - adda`PanelRepository`(interface)fieldwithacorrespondingconstructor
    - generatetestsfor`PanelService`
    - create`PanelRepositoryTestDouble`tosupportservicetesting,thistestclassimplements`PanelRepository`
    - implement`findBySection`andtest,implementjustenoughcodein`PanelRepositoryTestDouble`toenableservicetesting
    - implement`add`andtest,requiresvalidation
    - implement`update`andtest,requiresvalidation
    - implement`deleteById`andtest
11. Create`View`
    - add`Scanner`field
    - createread*methods:`readString`,`readRequiredString`,`readInt`,`readInt`(withmin/max)
12. Create`Controller`
    - addfieldsforserviceandviewwithcorrespondingconstructor
    - adda`run`method
13. Create`App`andthe`main`method.
    - instantiateallrequiredobjects:repository,service,view,andcontroller
    - runthecontroller
14. Workbackandforthbetweencontrollerandview.
    Runearlyandoften.Add`System.out.println`sasbreadcrumbsincontroller,butdon'tforgettoremovethemwhendevelopmentiscomplete.
    Determinethecorrectsequenceforservicecallsandviewcalls.Whatistheorder?
    - implement`chooseOptionFromMenu`and`printHeader`inview
    - usetheminthecontroller's`run`
    - implement`viewBySection`incontroller,completerequiredviewmethods:`readSection`,`printPanels`
    - implement`addPanel`incontroller,completerequiredviewmethods:`makePanel`,`readMaterial`,`printResult`
    - implement`updatePanel`incontroller,completerequiredviewmethods:`choosePanel`,`update`
    - implement`deletePanel`incontroller,completerequiredviewmethods(`deletePanel`canre-use`choosePanel`)
## ControllerPerspectives
### ViewPanelsbySection
1. collectsectionnamefromtheview
2. usethenametofetchpanelsfromtheservice
3. usetheviewtodisplaypanels
### AddaPanel
1. collectacompleteandnewpanelfromtheview
2. usetheservicetoaddthepanelandgrabitsresult
3. displaytheresultintheview
### UpdateaPanel
1. collectsectionnamefromtheview
2. usethenametofetchpanelsfromtheservice
3. displaythepanelsintheviewandallowtheusertochooseapanel(ifnopanelselected,abort)
4. updatepanelproperties(setters)intheview
5. usetheservicetoupdate/savethepanelandgrabitsresult
6. displaytheresultintheview
### DeleteaPanel
1. collectsectionnamefromtheview
2. usethenametofetchpanelsfromtheservice
3. displaythepanelsintheviewandallowtheusertochooseapanel(ifnopanelselected,abort)
4. usetheservicetodeletethepanelbyitsidentifier
5. displaysuccessorfailureintheview





