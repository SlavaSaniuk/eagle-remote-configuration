class Menu extends React.Component {


	render() {
		return (
			<div style={menu_blk}>
				<ProjectsMenu project_menu_title={translate_Project_menu_title} project_menu_content_NO_CONTENT_MSG={translate_Project_menu_content_NO_PROJECTS} 
					project_menu_content_add_btn_title={translate_Project_menu_add_btn}	/>
			</div>
		)
	}
}

ReactDOM.render(<Menu />, document.getElementById('left_menu'));