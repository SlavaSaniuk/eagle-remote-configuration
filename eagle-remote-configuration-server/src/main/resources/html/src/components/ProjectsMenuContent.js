class ProjectsMenuContent extends React.Component {
	constructor(props) {
		super(props);

		this.state = {wrapped: true};

		this.project_menu_content_block = React.createRef();
	}


	wrapMenu() {
		this.setState({wrapped: true});
		const blk = this.project_menu_content_block.current;
		blk.classList.toggle("unwrapped_projects_menu_content");
	}

	unwrapMenu() {
		this.setState({wrapped: false});
		const blk = this.project_menu_content_block.current;
		blk.classList.toggle("unwrapped_projects_menu_content");
	}


	render() {

		const isWrapped = this.state.wrapped;
		const areProjectsExist = true;

		let no_projects_message;
		if (areProjectsExist) {
			no_projects_message = <p style={projects_menu_content_no_content_msg}> {this.props.NO_CONTENT_MSG} </p>;
		}

		return (
			<div className="projects_menu_content" ref = {this.project_menu_content_block} >
				{no_projects_message}
				<AddButton btn_id='1' btn_title={this.props.content_add_btn_title} />
			</div>
			);
	}



}