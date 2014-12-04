

var app = angular.module('app', []);
app.controller('MyController', function($scope, $http){
	
    $scope.descricaoCrime={
    		nome:'',
    		descricao:''
    }
    
    $scope.listaEstados= new Array();
    $scope.taxasPorAno={
    		listaAnos: new Array([], [], [], [])
       		
    }
        
	var charts = function(){ new Highcharts.Chart({
    	
        chart: {
        	renderTo: 'divGrafico',
            type: 'bar'
            	
        },
        title: {
            text: 'Estatística Criminal No Brasil'
        },
        subtitle: {
            text: $scope.descricaoCrime.nome+''
        },
        xAxis: {
            categories: $scope.listaEstados,
            title: {
                text: 'Estados'
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Taxa (Registro de ocorrências /100.000 habitantes)',
                align: 'high'
            },
            labels: {
                overflow: 'justify'
            }
        },
        tooltip: {
            valueSuffix: ' 	Taxa (Registro de ocorrências/100.000 habitantes)'
        },
        plotOptions: {
            bar: {
                dataLabels: {
                    enabled: true
                }
            }
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'top',
            x: -40,
            y: 100,
            floating: true,
            borderWidth: 1,
            backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
            shadow: true
        },
        credits: {
            enabled: false
        },
        series: [{
            name: 'Ano 2009',
            data: $scope.taxasPorAno.listaAnos[0]
        }, {
            name: 'Ano 2010',
            data: $scope.taxasPorAno.listaAnos[1]
        }, {
            name: 'Ano 2011',
            data: $scope.taxasPorAno.listaAnos[2]
        },{
            name: 'Ano 2012',
            data: $scope.taxasPorAno.listaAnos[3]
        }]
        
});};
	
	   
    var config = {};
    config.params = {
        crime:''
    };
    
    $scope.atualizaTudo = function(){
    	selectCrime();
    	atualizaDescriçãoCrime();
        atualizaDados();
    }
    
    var selectCrime = function(){
        config.params.crime = $scope.crimeSelecionado;
                
    };
    
    var atualizaDescriçãoCrime = function(){
    	switch($scope.crimeSelecionado){
    	case 'homicidio':
    		$scope.descricaoCrime.nome='Homicídio';
    		$scope.descricaoCrime.descricao='Homicídio (do latim hominis excidium) é um crime que consiste no ato de uma pessoa matar outra. É tido como um crime universal, sendo punido em praticamente todas as culturas.';
    		break;
    	case 'furtodeveiculo':
    		$scope.descricaoCrime.nome='Furto de Veículo';
    		$scope.descricaoCrime.descricao='Furto é uma figura de crime prevista nos artigos 155 do Código Penal Brasileiro, e 203º do Código Penal Português, que consiste na subtração de coisa alheia móvel para si ou para outrem, com fim de assenhoramento definitivo. No furto não há violência ou grave ameaça, que difere do roubo por ser praticado mediante grave ameaça ou violência a pessoa.';
    		break;
    	case 'estupro':
    		$scope.descricaoCrime.nome='Estupro';
    		$scope.descricaoCrime.descricao='Estupro, coito forçado ou violação1 é a prática não consensual do sexo, imposto por meio de violência ou grave ameaça de qualquer natureza por ambos os sexos. Ele consiste em uma penetração da vagina ou do ânus (ou, no sentido mais amplo, também da boca) de uma ou mais vítimas por um ou mais indivíduos. As vítimas podem serhomens ou mulheres.';
    		break;
    	case 'rouboveiculo':
    		$scope.descricaoCrime.nome='Roubo de Veículo';
    		$scope.descricaoCrime.descricao='Roubo é o ato de subtrair coisa móvel alheia, para si ou para outro, mediante grave ameaça ou violência a pessoa (ou não), ou depois de havê-la, por qualquer meio, reduzido à impossibilidade de resistência. No Brasil, a pena prevista para este crime é de reclusão, de quatro a dez anos, e multa (art. 157, caput, do Código Penal).';
    		break;
    	case 'latrocinio':
    		$scope.descricaoCrime.nome='Latrocinio';
    		$scope.descricaoCrime.descricao='Latrocínio é um tipo penal, em alguns sistemas jurídicos, derivado do crime de roubo — o crime-fim —, em que o homicídio é o crime-meio, ou seja, mata-se para roubar.1 Em países de direito britânico, está englobado no delito de roubo. É considerado, doutrinariamente, um crime complexo, aquele em que há dois tipos criminais para sua configuração (delito pluriofensivo).';
    		break;
    	case 'lesaocorporalseguidodemorte':
    		$scope.descricaoCrime.nome='Lesão Corporal Seguida de Morte';
    		$scope.descricaoCrime.descricao='Lesão corporal é resultado de atentado bem sucedido à integridade corporal ou a saúde do ser humano, excluído o próprio autor da lesão. O crime pode ser praticado por ação ou omissão.'
    			+'Tratado no parágrafo 3o do artigo 129, este é um crime que somente admite a forma preterdolosa, pois se o agente agiu com dolo, ou seja, com a intenção de matar, trata-se de homicídio doloso.'
    			+'Neste caso, o agente tem que desejar ferir sua vítima (lesão corporal dolosa) mas a morte deve ser consequência imprevisível e indesejada de sua ação. Não admite tentativa. O dolo não é de matar, mas apenas de ferir a vítima e a morte sobreveio como resultado indesejado.';
    		break;
    	}
    	
    }
    /*
    var zerarDados = function(){
    	
    	while($scope.listaEstados.lenght){
    		$scope.listaEstados.pop();
    		console.log('zerar estados');

    	}
    	
    	while($scope.taxasPorAno.listaAnos[0].lenght){
    		$scope.taxasPorAno.listaAnos[0].pop;
    	}
    	
    	while($scope.taxasPorAno.listaAnos[1].lenght){
    		$scope.taxasPorAno.listaAnos[1].pop;
    	}
    	
    	while($scope.taxasPorAno.listaAnos[2].lenght){
    		$scope.taxasPorAno.listaAnos[2].pop;
    	}
    	
    	while($scope.taxasPorAno.listaAnos[3].lenght){
    		$scope.taxasPorAno.listaAnos[3].pop;
    	}
    }
*/    
    var atualizaDados = function(){
        $http.get('/', config).success(function(estatistica){
        	var i;
        	console.log('atualiza dados');
        	var j=0;
            for(i=0; i<estatistica.estados.length;i++){
            	$scope.listaEstados[i]=estatistica.estados[i].nome;
            	var x;
            	for(x=0;x<estatistica.estados[i].anos.length;x++){
            		$scope.taxasPorAno.listaAnos[x][j]=estatistica.estados[i].anos[x].taxa;
            		
            	}
            	j++;
            }
            charts();    
            
        }).error(function(){
            alert("ERRO NA BUSCA DOS DADOS");
        });
    };
    
    
    
    
});






