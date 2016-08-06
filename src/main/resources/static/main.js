var Main = class Main extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            lists: [],
            loadingLists: true,

            products: [],
            loadingProducts: true
        };

        $.get('http://localhost:8080/api/products', (products) => {
            this.setState({products});
        })
        .always((err) => {
            this.setState({loadingProducts: false});
        });

        $.get('http://localhost:8080/api/lists', (lists) => {
            this.setState({lists});
        })
        .always((err) => {
            this.setState({loadingLists: false});
        });
    }

    render() {
        return (
            <div className="container">
                <div className="row">
                    <div className="col-sm-6 bootcards-list">
                        <h1>Product Lijstjes</h1>

                        <div className="panel panel-default">
                            <div className="list-group">
                                {this.renderLists()}
                            </div>
                        </div>
                    </div>
                    <div className="col-sm-6 bootcards-list">
                        <h1>Producten</h1>

                        <div className="panel panel-default">
                            <div className="list-group">
                                {this.renderProducts()}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }

    renderLists() {
        return this.state.lists.map((list, index) => {
            return (
                <div key={index} className='list-group-item'>
                   <h4 className="list-group-item-heading">{list.name}</h4>
                </div>
            );
        });
    }

    renderProducts() {
        return this.state.products.map((product, index) => {
            return (
                <div key={index} className='list-group-item'>
                   <h4 className="list-group-item-heading">{product.name} @ {product.price}</h4>
                </div>
            );
        });
    }
}

ReactDOM.render(<Main />, document.getElementById('react-root'));
