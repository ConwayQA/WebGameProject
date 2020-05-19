import axios from "axios";
import API from './API';
import React, { useState } from 'react';
import { Portal } from 'react-portal';
import { Grommet, grommet, Box, Main, Grid, Header, Menu, Text, TextInput, Image, Meter, Paragraph, Button } from 'grommet';
import { Menu as MenuIcon, Save as SaveIcon } from 'grommet-icons';
import {globalInventory} from './global';
import { render } from 'react-dom';

class CharacterInventory extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            toggler: false,
            id: '',
            inventory: []
        }

        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        this.setState({id: event.target.value});
    }
    
    getCharacterInventory() {
        let inventory = [];
        let createdInventory = [];
        API.get(`/getInventoryByCharacterID/${this.state.id}`)
        .then((response) => {
            console.log("Response data is: " , response.data);
            inventory = (response.data);
            console.log("Inventory from raw data: " , inventory);
            
            for (let i = 0; i < inventory.length; i++){
                createdInventory.push(inventory[i].item);
            }
            console.log("Array of Items from inventory: " , createdInventory);
            
            this.setState({
                toggler: true,
                inventory: createdInventory
            });
            
            })
        .catch((error) => {
            console.log(error);
        });

    }

    createTable() {
        let table = [];
        for(let i = 0; i < this.state.inventory.length; i++){
            table.push(<Image key={"item" + i} src={this.state.inventory[i].imgUrl} fit="contain" fill={true} ></Image>);
        }
        console.log(table);
        return table;
    }


    render() {
        if (this.state.toggler == false){
            return (
                <Grid rows={["auto"]} columns={["small","small","small"]} fill="vertical" pad={{"left":"xlarge","right":"xlarge"}} areas={[{"name":"Menu","start":[0,0],"end":[0,0]},{"name":"CharID","start":[1,0],"end":[1,0]}]}>
                    <Box align="center" justify="center" gridArea="Menu" fill={true}>
                    <Menu id = "menu!" label="Menu" size="medium" 
                                items={[
                                    {"label":"Save",},
                                    {"label":"Load", onClick: () => {this.getCharacterInventory()}}
                                ]} 
                                dropBackground={{"color":"dark-6","opacity":"strong"}} icon={<MenuIcon />} />
                    </Box>
                    <Box align="end" justify="center" gridArea="CharID" fill={true}>
                    <Text>
                        Character ID: 
                    </Text>
                    </Box>
                    <Box align="center" justify="center">
                    <TextInput id="CharacterId" size="small" type="text" value={this.state.id} onChange={this.handleChange} placeholder="5" icon={<SaveIcon />} reverse={true} />
                    </Box>
                </Grid>
            )
        } else {
            console.log("testes1")
            let table = [];
            table = this.createTable();
            return (
                <Grid rows={["auto"]} columns={["small","small","small"]} fill="vertical" pad={{"left":"xlarge","right":"xlarge"}} areas={[{"name":"Menu","start":[0,0],"end":[0,0]},{"name":"CharID","start":[1,0],"end":[1,0]}]}>
                    <Box align="center" justify="center" gridArea="Menu" fill={true}>
                <Menu label="menu!" size="medium" 
                    items={[
                        {"label":"Save"},
                        {"label":"Load", onClick: () => {this.getCharacterInventory()}}
                    ]} 
                    dropBackground={{"color":"dark-6","opacity":"strong"}} icon={<MenuIcon />} />
                    </Box>
                    <Box align="end" justify="center" gridArea="CharID" fill={true}>
                    <Text>
                        Character ID: 
                    </Text>
                    </Box>
                    <Box align="center" justify="center">
                    <TextInput id="CharacterId" size="small" type="text" value={this.state.id} onChange={this.handleChange} placeholder="5" icon={<SaveIcon />} reverse={true} />
                    </Box>

                    <Portal node={document.getElementById("inventoryPortal")}>
                        <Grid columns={["xxsmall","xxsmall","xxsmall","xxsmall","xxsmall"]} rows={["xxsmall","xxsmall","xxsmall","xxsmall","xxsmall","xxsmall","xxsmall"]} fill="vertical" gap={{"row":"medium","column":"medium"}} margin="large">
                            {table}
                        </Grid>
                    </Portal>
                </Grid > 
            )
        }

    }
}
export default CharacterInventory;