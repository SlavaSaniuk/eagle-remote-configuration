class AddButton extends React.Component {
	constructor(props) {
		super(props);

		this.btn_div = React.createRef();
	}

	getId(numeric_id) {
		return "add_button_" +numeric_id;
	}

	//Events handler
	onMouseEnter() {
		
		let btn_div_classes = this.btn_div.current.classList;

		btn_div_classes.contains("animation_addButton_mouseLeave") && btn_div_classes.remove("animation_addButton_mouseLeave");

		setTimeout(function() {
			btn_div_classes.add("animation_addButton_mouseEnter");
		}, 0.1);
		
	}

	onMouseLeave() {
		let btn_div_classes = this.btn_div.current.classList;

		btn_div_classes.contains("animation_addButton_mouseEnter") && btn_div_classes.remove("animation_addButton_mouseEnter");

		setTimeout(function() {
			btn_div_classes.add("animation_addButton_mouseLeave");
		}, 0.1);
	}

	render() {

		return (
			<div id={this.getId(this.props.btn_id)} style={Object.assign({}, add_btn_blk, add_projects_btn_size)}
				ref={this.btn_div} onMouseEnter={() => this.onMouseEnter()} onMouseLeave={() => this.onMouseLeave()}  >
				<img src="img/add_button-min.png" style={add_projects_btn_img} />
				<p style={add_projects_btn_text}> {this.props.btn_title} </p>
			</div>
			); 
	}

}