import React from 'react';
import { Grommet, grommet, Box, Main, Grid, Header, Menu, Text, TextInput, Image, Meter, Paragraph } from 'grommet';
import { Menu as MenuIcon, Save as SaveIcon } from 'grommet-icons';
import CharacterInventory from './components/CharacterInventory.js';
import { render } from 'react-dom';


export default () => {


    return (
      
    <Grommet theme={grommet}>
        <Box align="center" justify="center" background={{"color":"background","image":"url('https://drive.google.com/uc?id=1Knipix6Uvjo3wUYRZLiLB8nv334rexht')","position":"centre"}} direction="column" flex={true} fill={true} basis="full">
        <Main fill={true} flex={true} overflow="hidden">
          <Grid columns={["full"]} rows={["xsmall","2/3","1/4"]} areas={[{"name":"Header","start":[0,0],"end":[0,0]},{"name":"Main","start":[0,1],"end":[0,1]},{"name":"Footer","start":[0,2],"end":[0,2]}]} fill="vertical" gap="xxsmall">
            <Header align="stretch" direction="column" flex={true} justify="start" gap="xxsmall" fill={true} gridArea="Header" pad="xsmall" background={{"position":"center"}} overflow="hidden">
              <Box align="center" justify="center" overflow="auto" fill="vertical" gridArea="Buttons" background={{"color":"dark-6","opacity":"strong"}} border={{"color":"dark-1","size":"large","style":"double"}} elevation="large" round="medium" direction="row" alignSelf="center">
                <Grid rows={["auto"]} columns={["small","small","small"]} fill="vertical" pad={{"left":"xlarge","right":"xlarge"}} areas={[{"name":"Menu","start":[0,0],"end":[0,0]},{"name":"CharID","start":[1,0],"end":[1,0]}]}>
                  <Box align="center" justify="center" gridArea="Menu" fill={true}>
                    <Menu label="Menu" size="medium" 
                        items={[
                            {"label":"Save"},
                            {"label":"Load", onClick: () => {CharacterInventory()}}
                        ]} 
                        dropBackground={{"color":"dark-6","opacity":"strong"}} icon={<MenuIcon />} />
                  </Box>
                  <Box align="end" justify="center" gridArea="CharID" fill={true}>
                    <Text>
                      Character ID: 
                    </Text>
                  </Box>
                  <Box align="center" justify="center">
                    <TextInput size="small" type="text" placeholder="5" icon={<SaveIcon />} reverse={true} />
                  </Box>
                </Grid>
              </Box>
            </Header>
            <Box align="center" justify="center" gridArea="Main" direction="column" overflow="hidden" fill={true}>
              <Grid columns={["1/3","1/3","1/3"]} rows={["full"]} areas={[{"name":"Info","start":[0,0],"end":[0,0]},{"name":"Window","start":[1,0],"end":[1,0]},{"name":"Inventory","start":[2,0],"end":[2,0]}]} fill="vertical" pad={{"left":"xlarge","right":"xlarge"}}>
                <Box align="center" justify="center" gridArea="Info" overflow="hidden" flex={true} fill={true}>
                  <Image src="https://drive.google.com/uc?id=1zGqPA0G1Uu8EG3yjviuVSl1b2HzOrGsc" fit="contain" fill={true} />
                </Box>
                <Box align="center" justify="between" fill={true} gridArea="Window" overflow="hidden" flex={true}>
                  <Image src="https://drive.google.com/uc?id=1f9nonrrBLr3aEzWrvnZkUpA1sB6oWK6Z" fill={true} fit="contain" />
                </Box>
                <Box align="center" justify="end" gridArea="Window" pad={{"left":"large","right":"large","bottom":"medium"}} wrap={false} flex={true} fill={true}>
                  <Meter thickness="large" type="bar" values={[{"color":"graph-4","label":"enemyHealth","value":100}]} max={120} round={true} size="medium" />
                </Box>
                <Box align="center" justify="center" fill={true} direction="column" gridArea="Inventory" overflow="hidden" flex={true}>
                  <Image src="https://drive.google.com/uc?id=1qTKOpKhmB84-cnG2uu330JO3IIrexrZB" fill={true} fit="contain" />
                </Box>
              </Grid>
            </Box>
            <Box align="center" justify="center" overflow="hidden" gridArea="Footer" fill="vertical">
              <Grid columns={["1/4","1/2","1/4"]} fill="vertical" rows={["small"]} areas={[{"name":"Buttons","start":[0,0],"end":[0,0]},{"name":"Abilities","start":[1,0],"end":[1,0]},{"name":"Tooltip","start":[2,0],"end":[2,0]}]} pad={{"right":"xlarge","left":"xlarge"}}>
                <Box align="center" justify="center" gridArea="Buttons" direction="column" wrap={false}>
                  <Meter thickness="xlarge" type="circle" round={true} values={[{"color":"neutral-3","label":"Mana","value":120,"highlight":false}]} max={200} />
                </Box>
                <Box align="center" justify="center" overflow="hidden" wrap={false} gridArea="Buttons">
                  <Meter max={200} values={[{"highlight":false,"color":"status-critical","label":"Health","value":160}]} background="dark-6" thickness="large" type="circle" round={true} />
                </Box>
                <Box align="center" justify="start" fill="vertical" direction="column" flex={true} overflow="hidden" gridArea="Abilities" elevation="none" />
                <Box align="center" justify="start" direction="row" background={{"image":"url('')","color":"dark-6","opacity":"strong"}} fill={true} overflow="hidden" gridArea="Tooltip" hoverIndicator={false} border={{"size":"large","color":"dark-1","side":"all","style":"double"}} elevation="large" round="medium">
                  <Paragraph fill={true} textAlign="center" color="black" margin="xsmall">
                    Potion of superior healing
                    Heals the user for 500 health when used
                  </Paragraph>
                </Box>
              </Grid>
            </Box>
          </Grid>
        </Main>
      </Box>
      </Grommet>
  )
}