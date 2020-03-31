class ProjectsMenu extends React.Component {
	constructor(props) {
		super(props);

		this.state = {opened: false};
	}

	onClick(e) {
		e.preventDefault();
		console.log("Menu toggle clicked;");
		const isOpened = this.state.opened;
		console.log("Menu toggle state: " +isOpened.toString());
		isOpened ? this.closeMenu() : this.displayMenu();
	}

	displayMenu() {
		this.setState(
			{opened: true}
		);
		this.refs.menu_content.unwrapMenu();
	}

	closeMenu() {
		this.setState(
			{opened: false}
		);
		this.refs.menu_content.wrapMenu();
	}

	render() {

		const isOpened = this.state.opened;

		return (
			<div>
				<div style={projects_menu_title} onClick={(e) => this.onClick(e)}>
					<img src="img/menu_toggle.png" style= {isOpened ? projects_menu_title_icon_opened : projects_menu_title_icon} />
					<p style={projects_menu_title_text}> {this.props.project_menu_title} </p> 
				</div>
				<ProjectsMenuContent ref="menu_content" NO_CONTENT_MSG={this.props.project_menu_content_NO_CONTENT_MSG} 
				content_add_btn_title={this.props.project_menu_content_add_btn_title} />
			</div>
			);
	}


}